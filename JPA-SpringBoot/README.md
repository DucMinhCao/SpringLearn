JPA là một Framework tương tác với cơ sở dữ liệu, nó tự thiết lập connection với cơ sở dữ liệu, nó generate ra các table automatically dựa trên các Java CLass được gắn @Entiy    
Vậy Lợi ích của việc sử dụng JPA là gì ?  
- Chúng ta sẽ viết code ít phức tạp hơn, nhanh hơn, dễ bảo trì hơn thay vì phải tự mình thiết lập connection, bắt các exception, tự viết các statement, preparedstatements,......    
- Với JPA, chúng ta sẽ không cần biết ngôn ngữ của CSDL, ta không quan tâm các câu lệnh SELECT, UPDATE,..... vì JPA sẽ tự generate cho chúng ta    
- Ta có thể chuyển đổi bất kỳ CSDL nào mà mình muốn mà không cần biết tới ngôn ngữ của CSDL đó. Ví dụ ta có thể chuyển từ SQL-Server sang MySQL mà không cần quan tâm syntax của CSDL đó    
Bên cạnh những lợi ích thì JPA cũng có bất lợi     
- Do JPA tự động generate theo từng loại CSDL khác nhau nên sẽ tốn thêm một bước trung gian để generate ra với mỗi loại CSDL 
