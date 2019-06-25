Hello, lại là mình
hôm ni học cái chi ? 
ờ đầu tiên là Spring Dev tools, khi nào mình code á mà mình muốn thêm một cái chi mới vô thì sẽ phải restart lại server nhưng với cái DevTools này thì mình không cần nữa, nó tự restart cho mình, tiết kiệm một đống thời gian, tất cả nhữn gì cần làm là thêm cái dependency sau vô pom.xml
     
![](https://i.imgur.com/tPJSbtP.png)

thứ hai là Spring Actuator, đây là cái cục mà mình không hiểu cho lắm, ở thì đây là định nghĩa của nó theo mình việt sub. Spring Boot Actuator chúa một số các chức năng để giúp chúng ta quản lý và hiển thị ứng dụng của ta khi mà nó được đẩy ra production. Chúng ta có thể chọn quản lý và chỉnh sửa ứng dụng thông qua HTTP endpoints, với JMX hoặc bởi remote shell. Actuator endpoints cho phép chúng ta hiển thị và tương tác với ứng dụng. Spring boot chứa một số built-in endpoints có sẵn và chúng ta có thể tự thêm nó vào sử dụng dependency như sau

![](https://imgur.com/2G5ajr4.png)

thứ ba là chỉnh sửa một số thứ cơ bản trong application.properties.     
server.port=9090 đổi port của ứng dụng qua 9090
server.servlet.context-path=/hello đổi ngữ cảnh của ứng dụng qua localhost9090/hello
