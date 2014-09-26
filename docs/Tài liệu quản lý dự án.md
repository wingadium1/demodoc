TÀI LIỆU QUÁN LÝ DỰ ÁN
======================

MSHT14-16: Ứng dụng mobile monitor check status của server/dịch vụ mạng và cảnh báo và cấu hình
-------------------------------------------------------------------------------

-------------------------------------------------
##NGUỒN LỰC DỰ ÁN##
####NHÂN LỰC####
#####Đội phát triển ####
Đội phát triển gồm 4 thành viên:
1. [Trần Đức Nam](https://github.com/dynamotn/) (Team leader)
2. [Hoàng Thanh Sơn](https://github.com/wingadium1)
3. [Nguyễn Ngọc Minh](https://github.com/minhs2linh)
4. [Lê Tuấn Anh](https://github.com/anhltse03448)

Các thành viên trong đội đều là sinh viên Đại học FPT, trong đó Trần Đức Nam là sinh viên năm cuối, Nguyễn Ngọc Minh và Hoàng Thanh Sơn là sinh viên năm hai, Lê Tuấn Anh là sinh viên năm nhât, Team role chia rõ ràng: support nền tảng Linux nói riêng, nguồn mở nói chung do Trần Đức Nam đảm nhận, code Android do Nguyễn Ngọc Minh, documenting và ý tưởng giao diện do Hoàng Thanh Sơn, code layout xml Android do Lê Tuấn Anh. Các thành viên trong team còn nhiều hạn chế do đây là dự án đầu tiên về Android nói riêng va nguồn mở nói chung của các thành viên trong team.

Mentor
1. Nguyễn Thanh Hải
2. Lê Anh Tuấn
3. Nguyễn Đức Long
4. Nguyễn Vũ Hưng

####Cơ sở vật chất####
**Dụng cụ phát triển:**
Máy tính cá nhân của các thành viên
**Server Icinga-web triển khai thử nghiêm**
Hỗ trợ từ phía công ty NetNam
**Công cụ phát triển**

1. IDE: [Android Studio](https://developer.android.com/sdk/installing/studio.html)
2. Quản lý dự án: [Trello](https://trello.com/mhst1416)
3. Quản lí phiên bản: git version 2.1.1 (http://git-scm.com/downloads)
4. Kho mã nguồn: [GitHub](https://github.com/MHST14-16-Dream/Icinga-Mobile)
5. UML tool: [ArgoUML](http://argouml.tigris.org/)
6. Documentations: Libre Office
7. Document format: md, odt.



**Quy trình phát triển**: Quy trình upstreaming kết hợp phương pháp agile

***Upstreamming***

Quy trình upstreamming là quy trình kinh điển trong phát triển các dự án mã nguồn mở.





***Scrum Method***

Đội phát triện lựa chọn phương pháp Scrum trong quá trình phát triển dự án.
* Mentor đóng vai trò product owner, xử lí các vấn đề liên quan tới yêu cầu của dự án, tất nhiên vẫn đóng vai trò hướng dẫn kĩ thuật khi dự án có vướng mắc.
* Team leader đóng vai trò scrum master liên lạc với mentor và các thành viên trong đội
* Các thành viên tham gia phát triển dự án
***Phát triển lặp tăng tiến***
Dự án được chia thành nhiều sprint, mỗi sprint hoàn thành một số chức năng và kiểm thử hoàn chỉnh. Sau khi kết thúc sprint này chuyển tiếp sang sprint tiếp theo.

***Yêu cầu về mã nguồn***

1. Đảm bảo mã nguồn tự do và nguồn mở
2. Comment đẩy đủ
3. Có trích dẫn cụ thể tác giả mã nguồn và giấy phép 

***Phương thức giao tiếp và họp trong dự án***
Các thành viên giao tiếp thông qua :
1. Gặp mặt trực tiếp hàng tuần.
2. Trao đổi qua mailinglist, điện thoại và một số công cụ trực tuyến Hangout, Facebook.
3. Sử dụng hệ thống quản lý dự án Trello.

***Hướng phát triển tương lai của phần mềm***

Hiện tại phần mềm đã cung cấp các chức năng cơ bản về monitoring của Icinga như cảnh báo, theo dõi và comment. Các chức năng liên quan đến config các host vẫn chưa thực hiện do hạn chế về API của icinga-web. Tương lai có thể có thêm các chức năng như thêm bớt host, service, user or contact cho Icinga thông qua một số addons, plugin của Icinga, Nagios như Nagconf, Nconf,etc ...

