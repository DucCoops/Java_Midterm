   # Java_Midterm
## About the project
Đây là một trang web bán hàng gồm có các chức năng đơn giản như cho phép người dùng xem sản phẩm, tìm kiếm theo tên, thêm sản phẩm yêu thích vào giỏ hàng cũng như đặt hàng. Trang web được xây dựng bằng Java, Spring Boot, Thymeleaf and Bootstrap.

## Software Development Principles, Patterns, and Practices
Model-View-Controller (MVC): Mô hình MVC phân tách các khía cạnh khác nhau của ứng dụng (logic đầu vào, logic business, và giao diện người dùng logic), và cung cấp một kết nối giữa các yếu tố này.

Model đóng gói dữ liệu ứng dụng và nói chung họ sẽ bao gồm các POJO.

Tầng View chịu trách nhiệm hiển thị các dữ liệu Model và nói chung nó tạo ra HTML mà trình duyệt hiển thị ra.

Controller chịu trách nhiệm xử lý yêu cầu người sử dụng và xây dựng Model phù hợp và chuyển nó qua tầng View để hiển thị.

## Code Structure
Cấu trúc chương trình của trang web được tổ chức như sau:
- nguyenduc.springcommerce: bao gồm class main của chương trình.
- nguyenduc.springcommerce.controllers: Chứa các bộ điều khiển (controller) xử lý các yêu cầu (request) và phản hồi (response) với HTTP.
- nguyenduc.springcommerce.models:  các lớp của các đối tượng có trong chương trình.
- nguyenduc.springcommerce.repositories: Chứa các repository interface của ứng dụng.
- nguyenduc.springcommerce.services: Chứa các lớp service của chương trình.

Ngoài ra: 
- java_commerce.sql: chưa file cơ sở dữ liệu của chương trình.
- erd: chứa hình ảnh mô hình thực thể của chương trình.
- diagram.activity_diagrams: chức các biểu đồ hoạt động (activity diagrams) cho các chức năng có trong chương trình.
# Running the Application
Những công cụ cần có: 
- XAMPP
- Intellij (hoặc bất cứ các IDE hoặc Code Editer có thể chạy java)
Các bước thực hiện:
- Mở ứng dụng XAMPP, chọn start Apache và MySQL
- Truy cập phpMyAdmin bằng cách nhấn Admin bên cạnh nút Start MySQL
- Chọn import -> Chọn database java_ecommerce.sql -> Import
- Mở công cụ lập trình (trong phần này sẽ là Intellij)
- Open project
- Chạy class main (Application)
- Tới trình duyệt và gõ localhost:8080
- Sau khi dùng xong, tắt chương trình ở IDE và Stop Apache, MýQL trong 

