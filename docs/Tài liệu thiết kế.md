TÀI LIỆU THIẾT KẾ
=================

MHST 14-16 : Ứng dụng mobile monitor check status của server/dịch vụ mạng và cảnh báo và cấu hình
------------------------------------------------------------------------------------------

###THIẾT KẾ GIAO DIỆN###
----------------------




###THIẾT KẾ KIẾN TRÚC
------------------------
####KIẾN TRÚC ĐỀ NGHỊ####
Icinga-mobile là một front end của giao diện web [Icinga-web](https://www.icinga.org/icinga/screenshots/icinga-web/), sử dụng các API của [Icinga-web](https://www.icinga.org/icinga/screenshots/icinga-web/) để get, set, post data, qua đó hiển thị các thông số giống như [Icinga-web](https://www.icinga.org/icinga/screenshots/icinga-web/) trên nền thiết bị Android. Thực chất nhiệm vụ của Icinga-mobile là một trình duyệt chuyên biệt dùng với Icinga-web, thay thế dao diện trang web di động mà Icinga cung cấp.

#####KIẾN TRÚC ICINGA - MOBILE####

Icinga mobile gồm 3 module chính : 
* Icinga client: bao gồm các thư viện thực thi các task của ứng dụng. Tương tác với Icinga-web qua RestAPI
* Icinga service: service chạy ngầm thực hiện nhận thông tin xử lý thông tin từ icinga, hiển thị system notification.
* Main app: ứng dụng chính, tương tác trực tiếp với người dùng. Hiển thị thông tin về các host service.

![alt text](/image/Kientrucicinga.png "Kiến trúc Icinga-mobile")
######MÔ TẢ QUÁ TRÌNH HOẠT ĐỘNG ######

Người dùng thực hiện đăng nhập Main app là module thực hiện, gửi request trực tiếp với Icinga-web, khi thực hiện đăng nhập thành công Main app sẽ tạo ra một broadcast messenger, Module Icinga Service sẽ catch messenger này lấy thông tin của phiên đăng nhập,sau đó gửi request lấy thông tin mỗi 0.5s đến Icinga-web qua Library Icinga client.

###HIỆN THỰC HÓA USE CASE###
----------------------------



###THIẾT KẾ HỆ THỐNG ###
------------------------