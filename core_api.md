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
            "floor": 3,
            "const_type": 1,
            "address": "서울특별시 강남구",
            "images": [
                "/aadsdafaf",
                "/aadsdafaf",
                "/aadsdafaf",
                "/aadsdafaf",
                "/aadsdafaf"
            ],
            "timestamp": 1618879563000,
            "trans_done": false,
            "fav_count": 1
        },
        {
            "id": 2,
            "title": "매물 테스트용 제목 ~!@#$%^&*()_+1234asdf",
            "trans_type": 1,
            "deposit": 4000000,
            "fee": 4000000,
            "floor": 3,
            "const_type": 1,
            "address": "서울특별시 서초구",
            "images": [
                "/sdfsdf",
                "/sdfsdf",
                "/sdfsdf",
                "/sdfsdf"
            ],
            "timestamp": 1618892169000,
            "trans_done": false,
            "fav_count": 0
        },
        {
            "id": 3,
            "title": "매물 테스트용 제목 ~!@#$%^&*()_+1234asdf",
            "trans_type": 1,
            "deposit": 50000000,
            "fee": 60000000,
            "floor": 3,
            "const_type": 1,
            "address": "서울특별시 서초구",
            "images": [
                "/sdfsdf",
                "/sdfsdf",
                "/sdfsdf",
                "/sdfsdf",
                "/sdfsdf"
            ],
            "timestamp": 1618892293000,
            "trans_done": false,
            "fav_count": 0
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

### 응답 (OK 200)
|     Key      |     Type     |  Description   | Nullable |
| :----------: | :----------: | :------------: | :------: |
|   page_max   |     int      | 총 페이지 개수 |    -     |
| rooms_length |     int      | 매물 목록 크기 |    -     |
|    rooms     | Array\<Room> |   매물 목록    |    -     |

| Room Field |     Type      |                     Description                     | Nullable |
| :--------: | :-----------: | :-------------------------------------------------: | :------: |
|     id     |      int      |                   매물 고유 번호                    |    -     |
|   title    |    String     |          매물 제목</br>[30자 이내 텍스트]           |    -     |
| trans_type |      int      |     거래 종류</br>[1: 월세 / 2: 전세 / 3: 년세]     |    -     |
|  deposit   |      int      |      보증금</br>[거래 종류에 따라 0혹은 NULL]       |    O     |
|    fee     |      int      |       월세</br>[거래 종류에 따라 0혹은 NULL]        |    O     |
|   floor    |      int      | 매물 층</br>[N~-1: 지하 / 0: 정보 없음 / 1~N: 지상] |    O     |
| const_type |      int      |            건물 구조</br>[1~N / 방 개수]            |    O     |
|  address   |    String     |            매물 주소지</br>[도로명 주소]            |    -     |
|   images   | Array\<Image> |                  매물 이미지 목록                   |    -     |
| timestamp  |     long      |           게시 시간</br>[Unix Timestamp]            |    -     |
| trans_done |    boolean    | 매물 거래 완료 여부</br>[0: 거래 중 / 1: 거래 완료] |    -     |
| fav_count  |      int      |               관심 매물로 지정된 횟수               |    -     |

| Image Field |  Type  |        Description        | Nullable |
| :---------: | :----: | :-----------------------: | :------: |
|     id      |  int   |     이미지 고유 번호      |    -     |
|   user_id   |  long  | 업로드한 사용자 고유 번호 |    -     |
|    path     | String |        이미지 경로        |    -     |
|  timestamp  |  long  |        업로드 시간        |    -     |

</br>

## 매물 상세 조회
### GET /api/room/{room_id}
`(예시) /api/room/12345`
```
{
    "user_id": 53487632487314,
    "description": "매물 테스트 설명 ~!@#$%^&*()_+1234asdf",
    "manage_fee": 50000,
    "manage_tags": [
        "관리비1",
        "관리비2",
        "관리비3",
        "관리비4"
    ],
    "const_floor": 2,
    "valid_dimen": 40,
    "supply_dimen": 50,
    "avail_date": 1617217200000,
    "options": [
        "옵션1",
        "옵션2",
        "옵션3",
        "옵션4",
        "옵션5"
    ],
    "elevator": true,
    "parking": 0,
    "temp_sys": 2,
    "contact": "https://link.link/sdfsdf",
    "id": 3,
    "title": "매물 테스트용 제목 ~!@#$%^&*()_+1234asdf",
    "trans_type": 1,
    "deposit": 50000000,
    "fee": 60000000,
    "floor": 3,
    "const_type": 1,
    "address": "서울특별시 서초구",
    "images": [
        "/sdfsdf",
        "/sdfsdf",
        "/sdfsdf",
        "/sdfsdf",
        "/sdfsdf"
    ],
    "timestamp": 1618892293000,
    "trans_done": false,
    "fav_count": 0
}
```
</br>

### 요청
|  Path   | Type  |  Description   | Required |
| :-----: | :---: | :------------: | :------: |
| room_id |  int  | 매물 고유 번호 |    O     |

### 응답 (OK 200)
|     Key      |      Type      |                     Description                     | Nullable |
| :----------: | :------------: | :-------------------------------------------------: | :------: |
|      id      |      int       |                   매물 고유 번호                    |    -     |
|   user_id    |      long      |                매물 게시자 고유 번호                |    -     |
|    title     |     String     |          매물 제목</br>[30자 이내 텍스트]           |    -     |
| description  |     String     |                      매물 설명                      |    -     |
|  trans_type  |      int       |     거래 종류</br>[1: 월세 / 2: 전세 / 3: 년세]     |    -     |
|   deposit    |      int       |      보증금</br>[거래 종류에 따라 0혹은 NULL]       |    O     |
|     fee      |      int       |       월세</br>[거래 종류에 따라 0혹은 NULL]        |    O     |
|  manage_fee  |      int       |                       관리비                        |    O     |
| manage_tags  | Array\<String> |  관리비 항목</br>[관리비가 0혹은 NULL일 경우 NULL]  |    O     |
|    floor     |      int       | 매물 층</br>[N~-1: 지하 / 0: 정보 없음 / 1~N: 지상] |    O     |
| const_floor  |      int       |                      건물 층수                      |    O     |
|  const_type  |      int       |       건물 구조</br>[1부터 시작하며 방 개수]        |    O     |
| valid_dimen  |     float      |             전용 면적</br>[미터법 사용]             |    O     |
| supply_dimen |     float      |             공급 면적</br>[미터법 사용]             |    O     |
|  avail_date  |      long      |         입주 가능 일자</br>[Unix Timestamp]         |    O     |
|   options    | Array\<String> |                      옵션 목록                      |    O     |
|   elevator   |    boolean     |                     엘리베이터                      |    O     |
|   parking    |      int       |      가용 주차 공간</br>[수용 가능한 차량 수]       |    O     |
|   temp_sys   |      int       |     난방 종류</br>[1: 개별 / 2: 지역 / 3: 중앙]     |    O     |
|   address    |     String     |            매물 주소지</br>[도로명 주소]            |    -     |
|    image     | Array\<Image>  |                  매물 이미지 목록                   |    -     |
|   contact    |     String     |           연락처</br>[전화번호 혹은 링크]           |    -     |
|  timestamp   |      long      |           게시 시간</br>[Unix Timestamp]            |    -     |
|  trans_done  |    boolean     | 매물 거래 완료 여부</br>[0: 거래 중 / 1: 거래 완료] |    -     |
|  fav_count   |      int       |               관심 매물로 지정된 횟수               |    -     |

| Image Field |  Type  |        Description        | Nullable |
| :---------: | :----: | :-----------------------: | :------: |
|     id      |  int   |     이미지 고유 번호      |    -     |
|   user_id   |  long  | 업로드한 사용자 고유 번호 |    -     |
|    path     | String |        이미지 경로        |    -     |
|  timestamp  |  long  |        업로드 시간        |    -     |

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

|     POST     |      Type      |                     Description                     | Required |
| :----------: | :------------: | :-------------------------------------------------: | :------: |
|    title     |     String     |          매물 제목</br>[30자 이내 텍스트]           |    O     |
| description  |     String     |                      매물 설명                      |    O     |
|  trans_type  |      int       |     거래 종류</br>[1: 월세 / 2: 전세 / 3: 년세]     |    O     |
|   deposit    |      int       |      보증금</br>[거래 종류에 따라 0혹은 NULL]       |    -     |
|     fee      |      int       |       월세</br>[거래 종류에 따라 0혹은 NULL]        |    -     |
|  manage_fee  |      int       |                       관리비                        |    -     |
| manage_tags  | Array\<String> |  관리비 항목</br>[관리비가 0혹은 NULL일 경우 NULL]  |    -     |
|    floor     |      int       | 매물 층</br>[N~-1: 지하 / 0: 정보 없음 / 1~N: 지상] |    -     |
| const_floor  |      int       |                      건물 층수                      |    -     |
|  const_type  |      int       |       건물 구조</br>[1부터 시작하며 방 개수]        |    -     |
| valid_dimen  |     float      |             전용 면적</br>[미터법 사용]             |    -     |
| supply_dimen |     float      |             공급 면적</br>[미터법 사용]             |    -     |
|  avail_date  |      long      |         입주 가능 일자</br>[Unix Timestamp]         |    -     |
|   options    | Array\<String> |                      옵션 목록                      |    -     |
|   elevator   |    boolean     |                     엘리베이터                      |    -     |
|   parking    |      int       |      가용 주차 공간</br>[수용 가능한 차량 수]       |    -     |
|   temp_sys   |      int       |     난방 종류</br>[1: 개별 / 2: 지역 / 3: 중앙]     |    -     |
|   address    |     String     |            매물 주소지</br>[도로명 주소]            |    O     |
|   contact    |     String     |           연락처</br>[전화번호 혹은 링크]           |    O     |
|  trans_done  |    boolean     | 매물 거래 완료 여부</br>[0: 거래 중 / 1: 거래 완료] |    O     |

### 응답 (OK 200)
|   Key   | Type  |  Description   | Nullable |
| :-----: | :---: | :------------: | :------: |
| room_id |  int  | 매물 고유 번호 |    -     |

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
|    Key     |     Type     |  Description   | Nullable |
| :--------: | :----------: | :------------: | :------: |
|  page_max  |     int      | 총 페이지 개수 |    -     |
| fav_length |     int      | 매물 목록 크기 |    -     |
| fav_rooms  | Array\<Room> |   매물 목록    |    -     |

| Room Field |     Type      |                     Description                     | Nullable |
| :--------: | :-----------: | :-------------------------------------------------: | :------: |
|     id     |      int      |                   매물 고유 번호                    |    -     |
|   title    |    String     |          매물 제목</br>[30자 이내 텍스트]           |    -     |
| trans_type |      int      |     거래 종류</br>[1: 월세 / 2: 전세 / 3: 년세]     |    -     |
|  deposit   |      int      |      보증금</br>[거래 종류에 따라 0혹은 NULL]       |    O     |
|    fee     |      int      |       월세</br>[거래 종류에 따라 0혹은 NULL]        |    O     |
|   floor    |      int      | 매물 층</br>[N~-1: 지하 / 0: 정보 없음 / 1~N: 지상] |    O     |
| const_type |      int      |            건물 구조</br>[1~N / 방 개수]            |    O     |
|  address   |    String     |            매물 주소지</br>[도로명 주소]            |    -     |
|   images   | Array\<Image> |                  매물 이미지 목록                   |    -     |
| timestamp  |     long      |           게시 시간</br>[Unix Timestamp]            |    -     |
| trans_done |    boolean    | 매물 거래 완료 여부</br>[0: 거래 중 / 1: 거래 완료] |    -     |
| fav_count  |      int      |               관심 매물로 지정된 횟수               |    -     |


| Image Field |  Type  |        Description        | Nullable |
| :---------: | :----: | :-----------------------: | :------: |
|     id      |  int   |     이미지 고유 번호      |    -     |
|   user_id   |  long  | 업로드한 사용자 고유 번호 |    -     |
|    path     | String |        이미지 경로        |    -     |
|  timestamp  |  long  |        업로드 시간        |    -     |

</br>

## 관심 매물 등록
### GET /api/user/{user_id}/favorite/{room_id}/add
`(예시) /api/user/12332452435/favorite/12345/add?token=a9ace025c90c0da2161075da6ddd3492a2fca776`
</br>

### 요청
|  Path   | Type  |       Description       | Required |
| :-----: | :---: | :---------------------: | :------: |
| user_id | long  | 카카오 사용자 고유 번호 |    O     |
| room_id |  int  |     매물 고유 번호      |    O     |

| Query |  Type  |   Description   | Required |
| :---: | :----: | :-------------: | :------: |
| token | String | 카카오 API 토큰 |    O     |

### 응답 (OK 200)
|  Key  | Type  | Description | Required |
| :---: | :---: | :---------: | :------: |
|   -   |   -   |      -      |    -     |

</br>

## 관심 매물 삭제
### GET /api/user/{user_id}/favorite/{room_id}/delete
`(예시) /api/user/12332452435/favorite/12345/add?token=a9ace025c90c0da2161075da6ddd3492a2fca776`
</br>

### 요청
|  Path   | Type  |       Description       | Required |
| :-----: | :---: | :---------------------: | :------: |
| user_id | long  | 카카오 사용자 고유 번호 |    O     |
| room_id |  int  |     매물 고유 번호      |    O     |

| Query |  Type  |   Description   | Required |
| :---: | :----: | :-------------: | :------: |
| token | String | 카카오 API 토큰 |    O     |

### 응답 (OK 200)
|  Key  | Type  | Description | Required |
| :---: | :---: | :---------: | :------: |
|   -   |   -   |      -      |    -     |

</br>

## 사용자 정보 조회
### GET /api/user/{user_id}
`(예시) /api/user/1234234155`
</br>

### 요청
|  Path   | Type  |       Description       | Required |
| :-----: | :---: | :---------------------: | :------: |
| user_id | long  | 카카오 사용자 고유 번호 |    O     |

### 응답 (OK 200)
|     Key     | Type  |             Description             | Nullable |
| :---------: | :---: | :---------------------------------: | :------: |
|     id      | long  |          사용자 고유 번호           |    -     |
|   room_id   |  int  |           사용자 방 번호            |    O     |
| rate_manner |  int  | 사용자 매너 점수</br>[1~10: 별 5개] |    O     |
|  rate_room  |  int  |  매물 관련 점수</br>[1~10: 별 5개]  |    O     |
| rate_count  |  int  |             총 평가 수              |    O     |

</br>

## 사용자 평가 등록
### GET /api/
`(예시) /api/`
</br>

### 요청
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

### 응답 (OK 200)
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

</br>

## 사용자 평가 갱신
### GET /api/
`(예시) /api/`
</br>

### 요청
|  Key  | Type  | Description  | Required |
| :---: | :---: | :----------: | :------: |
| page  |  int  | page of list |    -     |

### 응답 (OK 200)
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