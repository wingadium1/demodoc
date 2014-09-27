Sử dụng
=======

Icinga-mobile
-------------
Icinga-mobile hoạt động giống các ứng dụng android khác, bạn chỉ cần cài đặt từ file ``*.apk`` là có thể sử dụng bình thường. Do tính chất của Icinga-mobile là ứng dụng monitor nên yêu cầu Internet Access (Mobile Internet, Wifi) khi sử dụng

Đăng nhập
-------------------------

Trong phiên sử dụng đầu tiên hoặc sau khi logout bạn cần đăng nhập lại hệ thống, sử dụng account của bạn trên Icinga-web. Để thực hiện đăng nhập bạn cần khởi chạy ứng dụng Icinga-mobile từ home screen hoặc trong application.

Hoặc nếu Icinga-mobile đang chạy bạn có thể nhấn nút menu setting và nhấn logout.


Sau đó chương trình sẽ hiện ra với giao diện như sau:


Màn hình overview
---------------------------

Màn hình overview gồm hai đồ thị quạt biếu hiện số lượng host, service mà Icinga đang monitor.


Danh sách các host service
--------------------------

Bạn có thể mở danh sách host bằng cách chọn tab Host ở side bar hoặc danh sách các host có trạng thái UP, DOWN, UNREACH bằng cách nhấn vào phần đồ thị quạt tương ứng trên màn hình overview.

Tương tự đối với service bạn cũng có mở danh sách service từ side bar hoặc từ màn hình Overview

Màn hình chi tiết của Host-service
----------------------------------

Từ màn hình danh sách host bạn có thể xem tình trạng từng host bằng cách nhấn vào item host đó trong list host.


Tương tự với danh sách host, danh sách service cũng được hiện ra từ các màn hình list service.

.. note::

   Tính năng này có một số hạn chế hiện tại như chưa hiện thị các service của từng host do kích thước hạn chế của các thiết bị di động. Chúng tôi đang thực hiện thử nghiệm lưu lượng Internet sử dụng của Icinga-mobile nên đã hạn chế Live Monitoring ở mức 500ms/request đến Icinga-web.Mọi ý kiến đóng góp luôn được hoan nghênh.

