package kr.banggooseok.core.controller;

import kr.banggooseok.aries.model.*;
import kr.banggooseok.aries.repository.AriesRepository;
import kr.banggooseok.kakao.model.UserInfoModel;
import kr.banggooseok.kakao.repository.KakaoAPIRepository;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/did/issuer")
public class IssuerController {

    @Resource(name = "kakaoAPIRepository")
    private KakaoAPIRepository kakaoAPIRepository;

    @Resource(name = "ariesRepository")
    private AriesRepository ariesRepository;

    @RequestMapping(value = "/agent", method = RequestMethod.GET)
    public Map<String, Object> getAgent() {

        Map<String, Object> map = new HashMap<>();

        map.put("port", 8031);

        return map;
    }

    @RequestMapping(value = "/invitation", method = RequestMethod.GET)
    public InvitationResult requestInvitation() throws Exception {
        // Create Invitation
        return ariesRepository.createInvitation("", true);
    }

    @RequestMapping(value = "/credential", method = RequestMethod.GET)
    public V20CredExRecord requestCredential(@RequestParam String connectionId,
                                                  @RequestParam String token) throws Exception {
        UserInfoModel userInfo = kakaoAPIRepository.getUserInfo(token);

        if (userInfo == null) {
            throw new Exception("Kakao API Token is not valid");
        }

        // Config Schema
        SchemaSendRequest schemaSendRequest = new SchemaSendRequest();
        schemaSendRequest.schemaName = "account_schema";
        schemaSendRequest.schemaVersion = "1.0";
        schemaSendRequest.attributes = new ArrayList<>();
        schemaSendRequest.attributes.add("kakao_id");
        schemaSendRequest.attributes.add("nickname");
        schemaSendRequest.attributes.add("email");
        schemaSendRequest.attributes.add("gender");
        schemaSendRequest.attributes.add("timestamp");

        // Create Schema
        TxnOrSchemaSendResult schemaSendResult = ariesRepository.createSchemas(connectionId, schemaSendRequest);

        // Config Credential definition
        CredentialDefinitionSendRequest creDefSendRequest = new CredentialDefinitionSendRequest();
        creDefSendRequest.revocationRegistrySize = 1000;
        creDefSendRequest.schemaId = schemaSendResult.sent.schemaId;
        creDefSendRequest.tag = "default";

        // Define Credential definition
        TxnOrCredentialDefinitionSendResult creDefSendResult = ariesRepository.createCredentialDef(connectionId, creDefSendRequest);

        // Config Issue Credential
        V20CredProposalRequestPreviewMand crePropRequest = new V20CredProposalRequestPreviewMand();
        crePropRequest.autoRemove = true;
        crePropRequest.comment = "string";
        crePropRequest.connectionId = connectionId;
        crePropRequest.credentialPreview = new V20CredPreview();
        crePropRequest.credentialPreview.type = "issue-credential/2.0/credential-preview";
        crePropRequest.credentialPreview.attributes = new ArrayList<>();
        crePropRequest.credentialPreview.attributes.add(new V20CredAttrSpec(
                null, "kakao_id", String.valueOf(userInfo.id)));
        crePropRequest.credentialPreview.attributes.add(new V20CredAttrSpec(
                null, "nickname", userInfo.kakaoAccount.profile.nickname));
        crePropRequest.credentialPreview.attributes.add(new V20CredAttrSpec(
                null, "email", userInfo.kakaoAccount.isEmailValid ? userInfo.kakaoAccount.email : ""));
        crePropRequest.credentialPreview.attributes.add(new V20CredAttrSpec(
                null, "gender", userInfo.kakaoAccount.isEmailValid ? userInfo.kakaoAccount.gender : ""));
        crePropRequest.credentialPreview.attributes.add(new V20CredAttrSpec(
                null, "timestamp", String.valueOf(new Date().getTime())));
        crePropRequest.filter = new V20CredProposalRequestPreviewMand.Filter();
        crePropRequest.filter.dif = new V20CredProposalRequestPreviewMand.Filter.DIF();
        crePropRequest.filter.dif.someDIFCriterion = "string";
        crePropRequest.filter.indy = new V20CredProposalRequestPreviewMand.Filter.Indy();
        crePropRequest.filter.indy.credDefId = creDefSendResult.sent.credentialDefinitionId;
        crePropRequest.filter.indy.issuerDID = creDefSendResult.sent.credentialDefinitionId.split(":")[0];
        crePropRequest.filter.indy.schemaId = schemaSendResult.sent.schemaId;
        crePropRequest.filter.indy.schemaIssuerDID = crePropRequest.filter.indy.issuerDID;
        crePropRequest.filter.indy.schemaName = schemaSendRequest.schemaName;
        crePropRequest.filter.indy.schemaVersion = schemaSendRequest.schemaVersion;
        crePropRequest.trace = true;

        return ariesRepository.issueCredential(crePropRequest);
    }
}
