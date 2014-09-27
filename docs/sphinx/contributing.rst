Tham gia phát triển
===================

Mã nguồn Icinga-mobile được đặt trên `Github` ở địa chỉ: https://github.com/MHST14-16-Dream/Icinga-Mobile

Để tham gia viết code bạn cần biết cách sử dụng `git`_ và lập trình `android`_

Hãy fork và tạo một branch mới từ branch ``master`` (xem phần Git Flow bên dưới), sau đó viết code và gửi chúng tôi một `pull request`_. Chúng tôi sẽ xem xét và commit code của bạn trong thời gian sớm nhất.

Tuy nhiên, bạn cũng có thể đóng góp theo những cách đơn giản hơn như
sử dụng phiên bản unstable và thông báo lỗi, viết hướng dẫn sử dụng,
viết blog, wiki cho trang github, chia sẻ với cộng đồng về ứng dụng monitor này.

Để góp ý cho chúng tôi cũng như tham gia và dự án bạn có thể thông qua mailinglist `[MHST14-Dream]`_ trên Google Mail nếu bạn có mong muốn giúp sức. Mọi sự đóng góp của các bạn dù dưới hình thức nào cũng đều được chúng tôi hết sức trân trọng.

.. _Github: https://github.com/MHST14-16-Dream/Icinga-Mobile
.. _git: http://git-scm.com/book
.. _android: http://developer.android.com/index.html
.. _pull request: https://help.github.com/articles/using-pull-requests
.. _[MHST14-Dream]: https://groups.google.com/forum/?utm_medium=email&utm_source=footer#!forum/mhst14-16-dream

Cấu trúc code
-------------

Chúng tôi thực hiện module hóa phần mềm để dễ dàng cho các bước phát triển tiếp theo ở phần Backend theo một chuẩn API nên Icinga-mobile được chia thành 3 phần chính là Main Application, Icinga service gồn các service chạy ngầm và bộ thư viện dùng chung Icinga Client giao tiếp với API của Icinga-web

Coding style
------------

Chúng tôi cố gắng tạo một Coding Convention chuẩn cho toàn dự án, Coding Convention này được xây dựng chủ yếu dựa trên Android Coding Convention và Java Coding Convention, tài liệu chi tiết được lưu trong thư mục docs trên trang GitHub của dự án.

Documentation
-------------

Chúng tôi cũng cố gắng viết code thật dễ hiểu với documentation,
comment đầy đủ trong code nên hi vọng bạn sẽ không cảm thấy khó khăn
khi tìm hiểu code của Icinga-mobile.

Thành phần Main Apps có sử dụng các thư viện xử lý Json, Thành phần Icinga client chứa các thư viện column name của Icinga-web database để sử dụng Icinga Web REST API 

Bạn có thể tìm thấy tài liệu về cách sử dụng chúng dưới đây:

* Json: http://json.org/
* Icinga Web REST API: http://docs.icinga.org/latest/en/icinga-web-api.html

Testing
-------

Nhóm phát triển Icinga-mobile sử dụng Agile method trong việc phát triển phần mềm, qua đó tuân theo mô hình `test-driven software development`_. Trong quá trình này, chúng tôi chủ yếu sử dụng phương pháp Unit test,bạn luôn phải viết test mỗi khi thay đổi code. Các test case có thể tìm thấy trong thư con mục ``Androidtest`` nằm trong mỗi thành phần của dự án.

Với unit test chúng tôi sử dụng chủ yếu Framework testing Junit.
Để chạy test, bạn cần cài viết class java test kế thừa từ class **AndroidTestCase**, sau đó run test trong IDE(bạn nên sử dụng Android Studio)

.. _test-driven software development: http://en.wikipedia.org/wiki/Test-driven_development

Git Flow
--------

Icinga-mobile được quản lý bằng Git.  Phương pháp này sử dụng có thể trình bày sơ lược như sau:

- Repo chính trên Github hiện đang là branch là ``master`` chứa tất cả
  những thay đổi mới nhất của Icinga-mobile. Tuy nhiên, thường ít khi commit trực tiếp vào ``master`` ngoài những commit sửa lỗi nhỏ.

- Khi thực hiện một tính năng mới thì lập trình viên tạo branch mới với
  tên ``issue/<tên tính năng>``. Sau khi kiểm tra toàn bộ thì merge branch này với ``master`` và xóa branch ``issue/*`` đi. Từ sau trở đi tính năng này sẽ được maintain trong branch ``master``.

- Khi có đủ tính năng mới và các lỗi quan trọng đã được sửa thì có thể
  tính đến việc release phiên bản major mới. Khi đó tạo branch ``release/v<phiên bản>``
  và thực hiện tất cả các commit sửa lỗi cho phiên bản này tại đây. Khi tất cả các lỗi trước khi phát hành được sửa hết thì sửa version string trong source code, tạo tag cho phiên bản mới và merge vào master. Trong toàn bộ quá trình này, các thay đổi mới vẫn thực hiện ở các issue branch như bình thường. Sau khi release thì các commit ở ``release/*`` được merge trở lại vào ``master``.

- Sau khi release phiên bản major mà phát hiện lỗi đặc biệt nghiêm trọng
  nào đó thì phải sửa ngay lập tức và release phiên bản minor với branch
  ``hotfix/v<phiên bản>``. Quy trình giống như một branch ``release/*``.
  Sau khi release phải merge lại vào ``master``.

Chi tiết về phương pháp git flow:
    http://nvie.com/posts/a-successful-git-branching-model/

Công cụ hỗ trợ ``git-flow``:
    http://jeffkreeftmeijer.com/2010/why-arent-you-using-git-flow/

