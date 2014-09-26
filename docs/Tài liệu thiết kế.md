TÀI LIỆU THIẾT KẾ
=================

MHST 14-16 : Ứng dụng mobile monitor check status của server/dịch vụ mạng và cảnh báo và cấu hình
------------------------------------------------------------------------------------------

###THIẾT KẾ DAO DIỆN###
----------------------




###THIẾT KẾ KIẾN TRÚC
------------------------
####KIẾN TRÚC ĐỀ NGHỊ####
Icinga-mobile là một front end của giao diện web [Icinga-web](https://www.icinga.org/icinga/screenshots/icinga-web/), sử dụng các API của [Icinga-web](https://www.icinga.org/icinga/screenshots/icinga-web/) để get, set, post data, qua đó hiển thị các thông số giống như [Icinga-web](https://www.icinga.org/icinga/screenshots/icinga-web/) trên nền thiết bị Android. Thực chất nhiệm vụ của Icinga-mobile là một trình duyệt chuyên biệt dùng với Icinga-web, thay thế dao diện trang web di động mà Icinga cung cấp.

#####KIẾN TRÚC ICINGA - MOBILE####
######MÔ TẢ QUÁ TRÌNH HOẠT ĐỘNG ######
Khi người dùng yêu cầu một hành động nào đó, họ thao tác trực tiếp lên UI, UI xử lý, gọi các method từ Icinga thông qua NetControler gọi các API của Icinga-web, nhận lại thông tin dưới dạng JSON xử lý và hiển thị lên UI.



###HIỆN THỰC HÓA USE CASE###
----------------------------

###THIẾT KẾ HỆ THỐNG ###
------------------------