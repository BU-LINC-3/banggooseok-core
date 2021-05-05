package kr.banggooseok.core.controller;

import kr.banggooseok.aries.model.*;
import kr.banggooseok.aries.repository.AriesRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping(value = "/api/did/verifier")
public class VerifierController {

    @Resource(name = "ariesRepository")
    private AriesRepository ariesRepository;

    @RequestMapping(value = "/knock", method = RequestMethod.GET)
    public V20PresExRecord knock(@RequestParam String alias) throws Exception {

        // Get Connections
        ConnectionList connectionList = ariesRepository.getConnections(alias);
        ConnRecord connRecord = connectionList.results.get(0);

        // Get Credential Definitions
        CredentialDefinitionsCreatedResult creDefCreatedResult = ariesRepository.getCredentialDefs("account_schema");
        String creDefId = creDefCreatedResult.credentialDefinitionIds.get(0);

        // Config Request
        V20PresSendRequestRequest presSendReqRequest = new V20PresSendRequestRequest();
        presSendReqRequest.comment = "string";
        presSendReqRequest.connectionId = connRecord.connectionId;
        presSendReqRequest.presentationRequest = new V20PresRequestByFormat();
        presSendReqRequest.presentationRequest.indy = new V20PresRequestByFormat.Indy();
        presSendReqRequest.presentationRequest.indy.name = "Proof of ".concat(alias);
        presSendReqRequest.presentationRequest.indy.version = "1.0";
        presSendReqRequest.presentationRequest.indy.requestedAttributes = new HashMap<>();
        List<Map<String, Object>> restrictions = new ArrayList<>();
        Map<String, Object> restriction = new HashMap<>();
        restriction.put("cred_def_id", creDefId);
        restrictions.add(restriction);
        presSendReqRequest.presentationRequest.indy.requestedAttributes.put(
                "0_kakao_id_uuid", new IndyProofReqAttrSpec("kakao_id", null, null, restrictions));
        presSendReqRequest.presentationRequest.indy.requestedPredicates = new HashMap<>();

        // Send proof request
        return ariesRepository.requestProof(presSendReqRequest);
    }

    @RequestMapping(value = "/verified", method = RequestMethod.GET)
    public Map<String, Object> verify(@RequestParam String pres_ex_id) throws Exception {
        Map<String, Object> map = new HashMap<>();

        // Verify Presentation
        map.put("verified", ariesRepository.getPresentation(pres_ex_id).verified.equals("true"));

        return map;
    }
}
