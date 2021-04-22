# 방구석 코어 API 문서 (작성 중)

## 매물 목록 조회
### GET /api/room/list/{page}
`(예시) /api/room/list/0`
```
{
    "rooms": [
        {
            "id": 1,
            "title": "매물 테스트용 제목 ~!@#$%^&*()_+1234asdf",
            "trans_type": 1,
            "deposit": 1000000,
            "fee": 1000000,
            "const_type": 1,
            "floor": 3,
            "address": "서울특별시 강남구",
            "images": [
                "/aadsdafaf",
                "/aadsdafaf",
                "/aadsdafaf",
                "/aadsdafaf",
                "/aadsdafaf"
            ]
        }
    ],
    "rooms_length": 3,
    "page_max": 1
}
```
</br>

### 요청
| Path  | Type  |        Description         | Required |
| :---: | :---: | :------------------------: | :------: |
| page  |  int  | 목록 페이지 번호</br>[0~N] |    O     |

### 응답
|     Key      |     Type     |  Description   | Nullable |
| :----------: | :----------: | :------------: | :------: |
|   page_max   |     int      | 총 페이지 개수 |    -     |
| rooms_length |     int      | 매물 목록 크기 |    -     |
|    rooms     | Array\<Room> |   매물 목록    |    -     |

</br>

| Room Field |      Type      |                   Description                    | Nullable |
| :--------: | :------------: | :----------------------------------------------: | :------: |
|     id     |      int       |                  매물 고유 번호                  |    -     |
|   title    |     String     |         매물 제목</br>[30자 이내 텍스트]         |    -     |
| trans_type |      int       |   거래 종류</br>[1: 월세 / 2: 전세 / 3: 년세]    |    -     |
|  deposit   |      int       |  보증금</br>[거래 종류에 따라 NULL 혹은 빈 값]   |    O     |
|    fee     |      int       |   월세</br>[거래 종류에 따라 NULL 혹은 빈 값]    |    O     |
| const_type |      int       |          건물 구조</br>[1~N / 방 개수]           |    O     |
|   floor    |      int       | 매물 층</br>[N~-1: 지하 / 0: 반지하 / 1~N: 지상] |    O     |
|  address   |     String     |          매물 주소지</br>[도로명 주소]           |    -     |
|   images   | Array\<String> |    매물 이미지 목록</br>[이미지 경로만 표시]     |    -     |

</br>

## 매물 상세 조회
### GET /api/room/{room_id}
`(예시) /api/room/12345`
</br>

### 요청
|  Path   | Type  |  Description   | Required |
| :-----: | :---: | :------------: | :------: |
| room_id |  int  | 매물 고유 번호 |    O     |

### 응답
|     Key      |      Type      |                    Description                    | Nullable |
| :----------: | :------------: | :-----------------------------------------------: | :------: |
|      id      |      int       |                  매물 고유 번호                   |    -     |
|   user_id    |      long      |               매물 게시자 고유 번호               |    -     |
|    title     |     String     |         매물 제목</br>[30자 이내 텍스트]          |    -     |
| description  |     String     |                     매물 설명                     |    -     |
|  trans_type  |      int       |    거래 종류</br>[1: 월세 / 2: 전세 / 3: 년세]    |    -     |
|   deposit    |      int       |   보증금</br>[거래 종류에 따라 NULL 혹은 빈 값]   |    O     |
|     fee      |      int       |    월세</br>[거래 종류에 따라 NULL 혹은 빈 값]    |    O     |
|  manage_fee  |      int       |                      관리비                       |    O     |
| manage_tags  | Array\<String> | 관리비 항목</br>[관리비가 0혹은 NULL일 경우 NULL] |    O     |
|    floor     |      int       | 매물 층</br>[N~-1: 지하 / 0: 반지하 / 1~N: 지상]  |    O     |
| const_floor  |      int       |                     건물 층수                     |    O     |
|  const_type  |      int       |      건물 구조</br>[1부터 시작하며 방 개수]       |    O     |
| valid_dimen  |     float      |            전용 면적</br>[미터법 사용]            |    O     |
| supply_dimen |     float      |            공급 면적</br>[미터법 사용]            |    O     |
|  avail_date  |      long      |        입주 가능 일자</br>[Unix Timestamp]        |    O     |
|   options    | Array\<String> |                     옵션 목록                     |    O     |
|   elevator   |    boolean     |                    엘리베이터                     |    O     |
|   parking    |      int       |     가용 주차 공간</br>[수용 가능한 차량 수]      |    O     |
|   temp_sys   |      int       |    난방 종류</br>[1: 개별 / 2: 지역 / 3: 중앙]    |    O     |
|   address    |     String     |           매물 주소지</br>[도로명 주소]           |    -     |
|    image     | Array\<String> |     매물 이미지 목록</br>[이미지 경로만 표시]     |    -     |
|   contact    |     String     |          연락처</br>[전화번호 혹은 링크]          |    -     |
|  timestamp   |      long      |          게시 시간</br>[Unix Timestamp]           |    -     |

</br>

## 매물 등록
### POST /api/room/submit
`(예시) /api/room/submit?token=a9ace025c90c0da2161075da6ddd3492a2fca776&user_id=12345345463462`
</br>

### 요청
|  Query  |  Type  |       Description       | Required |
| :-----: | :----: | :---------------------: | :------: |
|  token  | String |     카카오 API 토근     |    O     |
| user_id |  long  | 카카오 사용자 고유 번호 |    O     |

|  POST   |  Type  |       Description       | Required |
| :-----: | :----: | :---------------------: | :------: |
|  token  | String |     카카오 API 토근     |    O     |
| user_id |  long  | 카카오 사용자 고유 번호 |    O     |

### 응답
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

</br>

## 관심 매물 등록
### GET /api/user/{user_id}/favorite/add
`(예시) /api/user/12332452435/favorit/add?token=a9ace025c90c0da2161075da6ddd3492a2fca776&room_id=123456`
</br>

### 요청
|  Path   | Type  |       Description       | Required |
| :-----: | :---: | :---------------------: | :------: |
| user_id | long  | 카카오 사용자 고유 번호 |    O     |

|  Query  |  Type  |   Description   | Required |
| :-----: | :----: | :-------------: | :------: |
|  token  | String | 카카오 API 토큰 |    O     |
| room_id |  int   | 매물 고유 번호  |    O     |

### 응답
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

</br>

## 관심 매물 조회
### GET /api/user/{user_id}/favorite/list/{page}
`(예시) /api/user/123412342434/favorite/list/0`
</br>

### 요청
|  Path   | Type  |       Description       | Required |
| :-----: | :---: | :---------------------: | :------: |
| user_id | long  | 카카오 사용자 고유 번호 |    O     |
|  page   |  int  |    목록 페이지 번호     |    O     |

### 응답
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

</br>

## 평판 등록/갱신
### GET /api/
`(예시) /api/`
</br>

### 요청
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

### 응답
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

</br>

## 계정 정보 조회
### GET /api/user/{user_id}
`(예시) /api/user/1234234155`
</br>

### 요청
|  Path   | Type  |       Description       | Required |
| :-----: | :---: | :---------------------: | :------: |
| user_id | long  | 카카오 사용자 고유 번호 |    O     |

### 응답
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

</br>

## 거래 내역 조회
### GET /api/user/{user_id}/transaction/list
`(예시) /api/user/1234532455/transaction/list`
</br>

### 요청
|  Path   | Type  |       Description       | Required |
| :-----: | :---: | :---------------------: | :------: |
| user_id | long  | 카카오 사용자 고유 번호 |    O     |

### 응답
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

</br>


채팅창