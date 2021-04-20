# 방구석 코어 API 문서 (작성 중)

## 매물 목록 조회
### GET /api/room/list/{page}
`(예시) /api/room/list/0`
</br>

### 요청
| Path  | Type  |   Description    | Required |
| :---: | :---: | :--------------: | :------: |
| page  |  int  | 목록 페이지 번호 |    O     |

</br>

### 응답
|    Key    |     Type     |    Description     | Nullable |
| :-------: | :----------: | :----------------: | :------: |
| page_max  |     int      | 마지막 페이지 번호 |    -     |
| room_size |     int      |   매물 목록 크기   |    -     |
|   rooms   | Array\<Room> |     매물 목록      |    -     |

</br>

| Room Field |      Type      |   Description    | Nullable |
| :--------: | :------------: | :--------------: | :------: |
|     id     |      int       |  매물 고유 번호  |    -     |
|   title    |     String     |    매물 제목     |    -     |
| trans_type |      int       |    거래 종류     |    -     |
|  deposit   |      int       |      보증금      |    O     |
|    fee     |      int       |       월세       |    O     |
| const_type |      int       |    건물 구조     |    -     |
|  address   |     String     |   매물 주소지    |    -     |
|   image    | Array\<String> | 매물 이미지 목록 |    -     |

</br></br></br>

## 매물 상세 조회
### GET /api/room/{room_id}
`(예시) /api/room/12345`
</br>

### 요청
|  Path   | Type  |  Description   | Required |
| :-----: | :---: | :------------: | :------: |
| room_id |  int  | 매물 고유 번호 |    O     |

</br>

### 응답
|     Key      |      Type      |      Description      | Nullable |
| :----------: | :------------: | :-------------------: | :------: |
|      id      |      int       |    매물 고유 번호     |    -     |
|   user_id    |      long      | 매물 게시자 고유 번호 |    -     |
|    title     |     String     |       매물 제목       |    -     |
| description  |     String     |       매물 설명       |    -     |
|  trans_type  |      int       |       거래 종류       |    -     |
|     fee      |      int       |         월세          |    O     |
|  manage_fee  |      int       |        관리비         |    O     |
| manage_tags  | Array\<String> |      관리비 항목      |    O     |
|   deposit    |      int       |        보증금         |    O     |
|    floor     |      int       |        매물 층        |    O     |
| const_floor  |      int       |       건물 층수       |    O     |
|  const_type  |      int       |       건물 구조       |    O     |
| valid_dimen  |     double     |       전용 면적       |    O     |
| supply_dimen |     double     |       공급 면적       |    O     |
|  avail_date  |      long      |    입주 가능 일자     |    -     |
|   options    | Array\<String> |       옵션 목록       |    O     |
|   elevator   |    boolean     |      엘리베이터       |    O     |
|   parking    |      int       |    가용 주차 공간     |    O     |
|   temp_sys   |      int       |       난방 종류       |    O     |
|   address    |     String     |      매물 주소지      |    -     |
|    image     | Array\<String> |   매물 이미지 목록    |    -     |
|   contact    |     String     |        연락처         |    -     |

</br></br></br>

