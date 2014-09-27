TÀI LIỆU PHÂN TÍCH RỦI RO DỰ ÁN
=========================

Ứng dụng mobile monitor check status của server/dịch vụ mạng và cảnh báo và cấu hình
-------------------------------------------------------------------------------


--------------------------------------------------------------------------------
TABLE OF CONTENT
----------------
[Phân tích rủi do](#PHÂN TÍCH RỦI RO)

[1. Rủi do con người](#RỦI DO CON NGƯỜI)

[2. Rủi do tổ chức](#RỦI DO TỔ CHỨC)

[3. Rủi do công nghệ](#RỦI DO CÔNG NGHỆ)

[4. Rủi do công cụ](#RỦI DO CÔNG CỤ)

[5. Rủi do yêu cầu](#RỦI DO YÊU CẦU)

[6. Rủi do tính toán](#RỦI DO TÍNH TOÁN)

------------------------------------

##PHÂN TÍCH RỦI RO##

###RỦI DO CON NGƯỜI###

| Loại rủi ro        | Rủi do                   |Khả năng| Ảnh Hưởng |Giải Pháp|
| ------------------ |------------------       |-----------|-----------|---------|
|**Rủi do con người**| Thành viên không thể theo kịp kiến thức dự án| Thấp| Nghiêm Trọng|Tìm kiếm hỗ trợ từ mentor, thành viên tự cố gắng|
||Thành viên bị ốm trong khi thực hiện dự án|Trung bình|Trung bình|Tạo kế hoạch có khoảng trễ để hạn chế rủi do. Tính toán yêu cầu các thành viên khác làm bù phần việc|
||Một thành viên dừng dự án vì lý do riêng|Thấp|Nghiêm trọng|Tính toán ảnh hưởng đến quyết định. Nếu trong khoảng thời gian đầu, tìm kiếm thành viên mới, nếu cuối dự án thì điều chỉnh tiến độ cách thành viên làm bù|
||Thành viên không thể hoàn thành công việc trong sprint|Trung bình|Trung bình|Yêu cầu kêu gọi hỗ trợ từ thành viên khác, điều chỉnh công việc trong các sprint tiếp theo, sắp xếp lại thời gian|
---------------------------------------
Table 1: People Risk

---------------------------------------
###RỦI DO TỔ CHỨC ###

| Loại rủi ro        | Rủi do                   |Khả năng| Ảnh Hưởng |Giải Pháp|
| ------------------ |------------------       |-----------|-----------|---------|
|**Rủi do tổ chức**|Ban tổ chức mùa hè sáng tạo không hỗ trợ dự án từ đâu|Trung bình|Cực kì nghiêm trọng -Thảm Họa|Đội phát triển thảo luận và quyết định giải pháp. Cố gắng đánh giá cơ hội. Nếu tốt thì vẫn phát triển bằng vốn tự bỏ ra. Nếu không tốt thì dừng dự án lại.|
||Ban tổ chức MHST không tiếp tục hỗ trợ cho dự án khi đang phát triển.|Thấp|Rất nghiêm trọng|Họp đội phát triển lại tìm ra lí do. Nhóm trưởng động viên mọi người tiếp tục với vốn tự bỏ ra. Cố gắng cho ra phiên bản chất lượng tốt để thuyết phục mentor tiếp tục tài trợ.|
||Mentor không có thời gian khi đội phát triển đang gặp thử thách phải giải quyết|Trung Bình|Nghiêm trọng|Cố gắng tìm kiếm sự giúp đỡ trên cộng đồng mạng đặc biệt là cộng đồng nguồn mở, cố gắng liên lạc với mentor và bên hỗ trợ công nghệ của BTC MHST|
||Xuất hiện thay đổi chính sách của ban tổ chức MHST.|Thấp|Nghiêm trọng|Đánh giá và thay đổi dự án phù hợp với chính sách mới|
---------------------------------------
Table 2: Organizational Risk

---------------------------------------
###RỦI DO CÔNG NGHỆ ###

| Loại rủi ro        | Rủi do                   |Khả năng| Ảnh Hưởng |Giải Pháp|
| ------------------ |------------------       |-----------|-----------|---------|
|**Rủi do công nghệ**|Server cài đặt Icinga không thỏa mãn yêu cầu|Thấp|Nghiêm trọng| Báo cáo mentor tìm hướng giải quyết, tự giải quyết nếu trong khả năng|
||API Icinga-web thay đổi|Thấp|Không đáng kể|Icinga là hệ thống ít thay đổi, nếu có, đọc lại document của Icinga-web, Refactor code theo API mới|
||Kết nối Internet kém|Thấp|Trung bình|Sử dụng các kết nối khác thay thế, sử dụng các server icinga dự phòng trên VPS của thành viên, sử dụng Icinga-web chạy trên local host|
||Server không sẵn có|Trung bình|Trung bình| Sử dụng các server chạy trên VPS của thành viên, chạy trên local host, thông báo mentor cung cấp server|
---------------------------------------
Table 3: Technology Risk

---------------------------------------

###RỦI DO CÔNG CỤ###

| Loại rủi ro        | Rủi do                   |Khả năng| Ảnh Hưởng |Giải Pháp|
|------------------ |------------------       |-----------|-----------|---------|
|**Rủi do công cụ**|SDK, IDE khó sử dụng|Thấp|Nghiêm trọng|Tìm các IDE khác thay thế, nhờ sự tư vấn của mentor|
||Hạn chế ngân sách cho các công cụ|Trung bình|Trung bình|Sử dụng các công cụ Free- Open Source, đối với server cần dùng VPS yêu cầu mentor giúp đỡ|
---------------------------------------
Table 4: Tool Risk

---------------------------------------

###RỦI RO YÊU CẦU###
| Loại rủi ro        | Rủi do                   |Khả năng| Ảnh Hưởng |Giải Pháp|
| ------------------ |------------------       |-----------|-----------|---------|
|**Rủi do yêu cầu**|Thiết kế không thỏa mãn yêu cầu|Trung bình|Nghiêm trọng|Thiết kế lại, Hỏi mentor để được được đỡ|
||Yêu cầu dự án thay đổi|Thấp|Nghiêm trọng|Phân tích lại yêu cầu cẩn thận. Lên kế hoạch dự án chi tiết với đầy đủ chức năng. Chất lượng mã nguồn tốt|
||Mentor phàn nàn|Cao|Trung bình| Hiểu cặn kẽ yêu cầu của mentor|
---------------------------------------
Table 5: Requirement Risk

---------------------------------------

###RỦI DO TÍNH TOÁN###

| Loại rủi ro        | Rủi do                   |Khả năng| Ảnh Hưởng |Giải Pháp|
| ------------------ |------------------       |-----------|-----------|---------|
|**Rủi ro tính toán**|Thời gian tính toán để phát triển không đủ|Cao|Nghiêm trọng|Lên lịch trước, tính toán thời gian phát triển, xem xét mức độ ưu tiên của các thành phần|
||Chất lượng sản phẩm không đạt yêu cầu|Cao|Trung bình|Hỏi ý kiến mentor cặn kẽ. Cố gắng làm chất lượng mã nguồn tốt và sạch nhât. Phát triển lại nếu cần thiết|
||Phát triển chức năng không cần thiết|Thấp|Trung bình|Xóa bỏ chức năng, Sắp xếp lại công việc|
------------------------------
Table 6: Estimation Risk

--------------------------

