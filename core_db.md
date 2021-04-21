# 방구석 코어 DB 문서 (작성 중)

## rooms
### 매물 목록 테이블
</br>

### Column
|     Name     |  Type   |      Description      | Nullable |
| :----------: | :-----: | :-------------------: | :------: |
|      id      |   int   |    매물 고유 번호     |    -     |
|   user_id    |  long   | 매물 게시자 고유 번호 |    -     |
|    title     | String  |       매물 제목       |    -     |
| description  | String  |       매물 설명       |    -     |
|  trans_type  |   int   |       거래 종류       |    -     |
|     fee      |   int   |         월세          |    O     |
|  manage_fee  |   int   |        관리비         |    O     |
| manage_tags  | String  |      관리비 항목      |    O     |
|   deposit    |   int   |        보증금         |    O     |
|    floor     |   int   |        매물 층        |    O     |
| const_floor  |   int   |       건물 층수       |    O     |
|  const_type  |   int   |       건물 구조       |    O     |
| valid_dimen  |  float  |       전용 면적       |    O     |
| supply_dimen |  float  |       공급 면적       |    O     |
|  avail_date  |  long   |    입주 가능 일자     |    O     |
|   options    | String  |       옵션 목록       |    O     |
|   elevator   | boolean |      엘리베이터       |    O     |
|   parking    |   int   |    가용 주차 공간     |    O     |
|   temp_sys   |   int   |       난방 종류       |    O     |
|   address    | String  |      매물 주소지      |    -     |
|    image     | String  |   매물 이미지 목록    |    -     |
|   contact    | String  |        연락처         |    -     |
|  timestamp   |  long   |       게시 시간       |    -     |

</br>
