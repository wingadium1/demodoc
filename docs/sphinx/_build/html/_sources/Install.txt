Cài đặt
=======

Icinga-mobile có thể được cài đặt từ gói *apk từ trang release hoặc tự build file (nếu bạn muốn) trực tiếp từ mã nguồn.

Từ gói cài đặt apk
------------------

Người dùng có thể download các phiên bản của apk từ trang realese trên Github của dự án.

Từ mã nguồn
-----------

.. warning::

   Nếu bạn chưa thành thạo về Android và chỉ muốn sử dụng Icinga-mobile thì không nên cài đặt từ mã nguồn.

Icinga mobile là ứng dụng android nên bạn cần sử dụng công cụ Ant để biên dịch và build file apk. Nếu không có Ant bạn có thể download và cài đặt nó từ `trang chủ Apache Ant`_, sau đó bạn cần đặt đường dẫn PATH và JAVA_HOME cho máy tính của bạn.

Sau đó bạn tải mã nguồn tại https://github.com/MHST14-16-Dream/Icinga-Mobile/releases rồi giải nén. Hoặc dùng::

    git clone https://github.com/MHST14-16-Dream/Icinga-Mobile.git

Chuyển đến thư mục gốc của Icinga-Mobile

    cd /path/to/Icinga-Mobile

Compile với realease mode

    ant realse

Complie với debug mode

    ant debug

file apk sau khi build sẽ nằm trong thư mục con /bin .

.. _trang chủ Apache Ant: http://ant.apache.org/

Cài đặt server Icinga
---------------------

Bạn cần sử dụng một server Icinga với mô hình server client. Để cài đặt Icinga trên server bạn có thể tham khảo tại trang `Icinga documents`_ sau đó cài `Icinga-web frontend`_

.. _Icinga documents: http://docs.icinga.org/latest/en/quickstart.html
.. _Icinga-web frontend: http://docs.icinga.org/latest/en/icinga-web-scratch.html
