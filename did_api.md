# 방구석 DID API 문서
- [방구석 DID API 문서](#방구석-did-api-문서)
- [Issuer](#issuer)
  - [Agent 할당 및 별명 발급 요청 ✅](#agent-할당-및-별명-발급-요청-)
    - [GET /api/did/issuer/agent](#get-apididissueragent)
    - [요청](#요청)
    - [응답 (OK 200)](#응답-ok-200)
  - [연결 요청 ✅](#연결-요청-)
    - [GET /api/did/issuer/invitation](#get-apididissuerinvitation)
    - [요청](#요청-1)
    - [응답 (OK 200)](#응답-ok-200-1)
  - [Credential 발급 요청 ✅](#credential-발급-요청-)
    - [GET /api/did/issuer/credential](#get-apididissuercredential)
    - [요청](#요청-2)
    - [응답 (OK 200)](#응답-ok-200-2)
- [Verifier](#verifier)
  - [Proof 요구 요청 ✅](#proof-요구-요청-)
    - [GET /api/did/verifier/knock](#get-apididverifierknock)
    - [요청](#요청-3)
    - [응답 (OK 200)](#응답-ok-200-3)
  - [Proof 확인 ✅](#proof-확인-)
    - [GET /api/did/verifier/verified](#get-apididverifierverified)
    - [요청](#요청-4)
    - [응답 (OK 200)](#응답-ok-200-4)
<br/>

# Issuer
## Agent 할당 및 별명 발급 요청 ✅
### GET /api/did/issuer/agent
`(예시) /api/did/issuer/agent`
```
{
    "port": 8031,
    "alias": "holder-82207c42-814f-432e-8f31-9e3f3739105f"
}
```
<br/>

### 요청
| Query |  Type  |   Description   | Required |
| :---: | :----: | :-------------: | :------: |
| token | String | 카카오 API 토근 |    O     |

### 응답 (OK 200)
|  Key  |  Type  | Description | Nullable |
| :---: | :----: | :---------: | :------: |
| port  |  int   | Agent 포트  |    -     |
| alias | String |    별명     |    -     |

<br/>

## 연결 요청 ✅
### GET /api/did/issuer/invitation
`(예시) /api/did/issuer/invitation`
```
{
    "label": "faber.agent",
    "recipientKeys": [
        "3yzoFnsmgTubFvm8EMiJNFJG3t6oCS2hMs5dr9wDbjtK"
    ],
    "serviceEndpoint": "http://10.178.0.2:8020"
}
```
<br/>

### 요청
| Query |  Type  |   Description   | Required |
| :---: | :----: | :-------------: | :------: |
| token | String | 카카오 API 토근 |    O     |
| alias | String |      별명       |    O     |

### 응답 (OK 200)
|       Key       |  Type  | Description | Nullable |
| :-------------: | :----: | :---------: | :------: |
|      label      |  int   |             |    -     |
|  recipientKeys  | String |             |    -     |
| serviceEndpoint | String |             |    -     |

<br/>

## Credential 발급 요청 ✅
### GET /api/did/issuer/credential
`(예시) /api/did/issuer/credential`
```
{
    "state": "offer-sent",
    "thread_id": "e3e39169-4a22-4267-855e-aeefaa4a32ef",
    "updated_at": "2021-05-05 23:18:41.234088Z"
}
```
<br/>

### 요청
| Query |  Type  |   Description   | Required |
| :---: | :----: | :-------------: | :------: |
| token | String | 카카오 API 토근 |    O     |
| alias | String |      별명       |    O     |

### 응답 (OK 200)
|       Key       |  Type  | Description | Nullable |
| :-------------: | :----: | :---------: | :------: |
|      state      | String |             |    -     |
|    thread_id    | String |             |    -     |
| serviceEndpoint | String |             |    -     |

<br/>

# Verifier
## Proof 요구 요청 ✅
### GET /api/did/verifier/knock
`(예시) /api/did/verifier/knock`
```
{
    "state": "request-sent",
    "thread_id": "d5127e15-fff1-4d6d-b3f1-f9s9f8dab743",
    "updated_at": "2021-05-05 23:24:00.820621Z"
}
```
<br/>

### 요청
| Query |  Type  | Description | Required |
| :---: | :----: | :---------: | :------: |
| alias | String |    별명     |    O     |

### 응답 (OK 200)
|       Key       |  Type  | Description | Nullable |
| :-------------: | :----: | :---------: | :------: |
|      state      | String |             |    -     |
|    thread_id    | String |             |    -     |
| serviceEndpoint | String |             |    -     |

<br/>

## Proof 확인 ✅
### GET /api/did/verifier/verified
`(예시) /api/did/verifier/verified`
```
{
    "verified": true
}
```
<br/>

### 요청
|   Query    |  Type  |       Description        | Required |
| :--------: | :----: | :----------------------: | :------: |
| pres_ex_id | String | Presentation Exchange ID |    O     |

### 응답 (OK 200)
|   Key    | Type  | Description | Nullable |
| :------: | :---: | :---------: | :------: |
| verified | bool  |  증명 여부  |    -     |

<br/>
