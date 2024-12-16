# Book Ecommerce - README

## 1. Software Development Principles, Patterns, and Practices

### **Principles**

- **SOLID Principles**:
  - Single Responsibility: Mỗi class chỉ đảm nhận một nhiệm vụ cụ thể.
  - Open-Closed Principle: Code dễ dàng mở rộng nhưng hạn chế sửa đổi.
  - Dependency Inversion: Các module cấp cao không phụ thuộc vào module cấp thấp, sử dụng Interface và Dependency Injection.
- **DRY (Don't Repeat Yourself)**: Các đoạn mã được tái sử dụng tối đa.
- **KISS (Keep It Simple, Stupid)**: Mã nguồn được viết đơn giản, dễ hiểu.

### **Design Patterns**

- **MVC (Model-View-Controller)**:
  - **Model**: Quản lý dữ liệu và logic nghiệp vụ (nằm trong module `library`).
  - **View**: Hiển thị giao diện người dùng (resources).
  - **Controller**: Xử lý các yêu cầu HTTP (nằm trong module `admin` và `client`).
- **Repository Pattern**: Tách logic truy cập dữ liệu khỏi logic nghiệp vụ.
- **Service Layer**: Xử lý logic nghiệp vụ ở tầng dịch vụ trước khi giao tiếp với repository.

### **Practices**

- **RESTful APIs**: Tuân thủ chuẩn REST với các phương thức HTTP như GET, POST, PUT, DELETE.
- **Layered Architecture**: Code được tổ chức thành các tầng rõ ràng: Controller, Service, Repository, Model.
- **Unit Testing**: Sử dụng JUnit và MockMVC để kiểm thử API và logic nghiệp vụ.
- **Dependency Management**: Sử dụng Maven để quản lý thư viện.

---

## 2. Code Structure

Dự án được tổ chức theo mô hình **multi-module Maven project** với các module như sau:

### **1. Parent Project: book-ecommerce**

- **admin**: Chứa các API cho phía quản trị viên.
  - `controller`: Xử lý các yêu cầu HTTP.
  - `restcontroller`: Cung cấp các API REST.
  - `config`: Cấu hình Spring Security
  - `AppMain`: Lớp khởi chạy ứng dụng phía admin
    
    ![image](https://github.com/user-attachments/assets/b6fdfff7-61a5-4973-92e2-984ca0721c7f)

- **client**: Chứa các API cho phía người dùng.
  - `controller`: Điều khiển logic phía client.
  - `dto`: Đối tượng truyền dữ liệu.
  - `AppClientMain`: Khởi chạy ứng dụng phía cilent

    ![image](https://github.com/user-attachments/assets/24e358ea-11ea-47b1-8e06-94a78933a0eb)


- **library**: Chứa các thành phần dùng chung.
  - `model`: Các entity và lớp dữ liệu.
  - `repository`: Interface để truy cập cơ sở dữ liệu.
  - `service`: Logic nghiệp vụ chính.
  - `util`: Các tiện ích dùng chung.
 
    ![image](https://github.com/user-attachments/assets/61f6a6d5-4f4e-4254-836b-b8f6c5eda5b1)


### **2. Key Files**

- \`\`: Quản lý dependency cho toàn bộ dự án.
- \`\`: Cấu hình database và server.

---

## 3. Steps to Run the Application on a Local Machine

### **Prerequisites**

- **Java 17** hoặc cao hơn.
- **Maven** 3.x.
- **MySQL** hoặc các hệ quản trị cơ sở dữ liệu tương tự.
- **Postman** hoặc công cụ kiểm thử API.

### **Steps**

1. **Clone Repository**:

   ```bash
   [git clone https://github.com/your-repo/midterm.git](https://github.com/kahnhtrinh/Midterm.git)
   cd book-ecommerce
   ```

2. **Setup Database**:

   - Tạo một database trong MySQL:
     ```sql
     CREATE DATABASE book-ecommerce;
     ```
   - Cấu hình `application.properties` (ở module `admin/resources` và `client/resources`):
     ```properties
     spring.datasource.url=jdbc:mysql://localhost:3306/book-ecommerce
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.show-sql=true
     ```

3. **Build Project**:

   ```bash
   mvn clean install
   ```

4. **Run Application**:

   - **Admin module**:
     ```bash
     cd admin
     mvn spring-boot:run
     ```
   - **Client module**:
     ```bash
     cd client
     mvn spring-boot:run
     ```

5. **Verify Application**:

   - Admin APIs: `http://localhost:8081/admin`
   - Client APIs: `http://localhost:8080/client`

---

## 4. Verify APIs (CURL Commands and Postman Snapshots)

### **1. Get All Orders**

- **Endpoint**: `GET /api/orders`
- **CURL Command**:
  ```bash
  curl -X GET http://localhost:8080/api/orders
  ```

  ![image](https://github.com/user-attachments/assets/27bd7c2a-ee7f-4ec5-8974-a387e2e25a08)


### **2. Delete Order**

- **Endpoint**: `DELETE /api/orders/{id}`
- **CURL Command**:
  ```bash
  curl -X DELETE http://localhost:8080/api/orders/1
  ```
  ![image](https://github.com/user-attachments/assets/27bc3bea-bdba-4bfe-9922-a2dc616b4278)

### **3. Get All Products**

- **Endpoint**: `GET /api/products`
- **CURL Command**:
  ```bash
  curl -X GET http://localhost:8080/api/products
  ```
  ![image](https://github.com/user-attachments/assets/52ac8d3e-534c-41bf-b87c-c0f6ffdbd18c)

### **4. Delete Product**

- **Endpoint**: `GET /api/products/{id}`
- **CURL Command**:
  ```bash
  curl -X GET http://localhost:8080/api/products/4
  ```
  ![Screenshot 2024-12-17 005616](https://github.com/user-attachments/assets/2eb2b377-0596-4d01-96f3-1c0837151516)

---

## **5. Database**

![image](https://github.com/user-attachments/assets/ec79facd-797e-4f39-9a85-53a0eda43010)

## **6.Spring Security**
### **1. Config Spring Security của admin**
![image](https://github.com/user-attachments/assets/55950ede-38fe-4f94-b19b-33964e864913) 

### **2. Config Spring Security của client**
![image](https://github.com/user-attachments/assets/a1ad1b63-ce4b-462c-a3e1-972dac031a4e)


## **7. Unit Test**
![Screenshot 2024-12-17 013545](https://github.com/user-attachments/assets/30b40a97-d13a-424b-a8b6-ee615cd99473)

![image](https://github.com/user-attachments/assets/ac12738d-3929-47c2-a295-5ea6cbc6a130)

## **8. Video Demo**

Link video: 
https://drive.google.com/drive/u/1/folders/1bLv8SVptWmOCYxjJ9TPWmoGlguEgvRtY?q=sharedwith:public%20parent:1bLv8SVptWmOCYxjJ9TPWmoGlguEgvRtY
## **9. Contact**

- **Developer**: Châu Nguyễn Khánh Trình - 52200005
- **Email**: 52200005@student.tdtu.edu.vn

---
