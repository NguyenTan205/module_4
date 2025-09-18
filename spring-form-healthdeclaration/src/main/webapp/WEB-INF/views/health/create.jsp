<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create new Health</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: #fff;
            margin: 20px;
            color: #333;
            font-size: 14px;
            line-height: 1.5;
        }

        /* Tiêu đề */
        h3 {
            text-align: center;
            font-size: 22px;
            font-weight: bold;
            margin-bottom: 10px;
            text-transform: uppercase;
        }

        .notice {
            text-align: center;
            font-size: 14px;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .notice.red {
            color: red;
            font-size: 13px;
        }

        /* Bảng form */
        form table {
            width: 100%;
            max-width: 1000px;
            margin: 0 auto;
            border-collapse: collapse;
        }

        form td {
            padding: 10px;
            vertical-align: middle;
        }

        /* Label */
        form label {
            font-weight: 600;
            color: #000;
        }

        /* Input, Select */
        form input[type="text"],
        form input[type="number"],
        form input[type="email"],
        form input[type="date"],
        form select {
            width: 100%;
            padding: 8px 10px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            box-sizing: border-box;
            margin-top: 4px;
        }

        /* Checkbox */
        form input[type="checkbox"] {
            margin-right: 6px;
            transform: scale(1.1);
            vertical-align: middle;
        }

        /* Mục mô tả (p) */
        p {
            font-weight: bold;
            margin: 15px 0 5px;
            color: #000;
        }

        /* Submit button */
        input[type="submit"] {
            display: block;
            width: 220px;
            margin: 20px auto;
            padding: 12px;
            background-color: #d9534f;
            border: none;
            color: #fff;
            font-size: 16px;
            font-weight: bold;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.3s;
            text-transform: uppercase;
        }

        input[type="submit"]:hover {
            background-color: #c9302c;
        }

        /* Dấu (*) đỏ cho label */
        form label.required:after {
            content: " (*)";
            color: red;
            font-weight: normal;
            margin-left: 2px;
        }

        /* Nhóm chọn radio/checkbox trên cùng 1 hàng */
        .option-group {
            display: flex;
            gap: 15px;
            flex-wrap: wrap;
            align-items: center;
        }
    </style>
</head>
<body>
<h3>Tờ khai y tế</h3>
<form:form method="post" action="add-health" modelAttribute="health">
    <table>
        <tr>
            <td><form:label path="fullName">Họ tên: </form:label></td>
            <td><form:input path="fullName"/></td>
        </tr>
        <tr>
            <td><form:label path="yearOfBirth">Năm sinh: </form:label></td>
            <td><form:input path="yearOfBirth"/></td>
        </tr>
        <tr>
            <td><form:label path="gender">Giới tính: </form:label></td>
            <td>
                <form:select path="gender">
                    <form:option value="-Chọn">-Chọn-</form:option>
                    <form:option value="Nam">Nam</form:option>
                    <form:option value="Nữ">Nữ</form:option>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="nationality">Quốc tịch: </form:label></td>
            <td><form:input path="nationality"/></td>
        </tr>
        <tr>
            <td><form:label path="idNumber">Mã số công dân: </form:label></td>
            <td><form:input path="idNumber"/></td>
        </tr>
        <tr>
            <td><form:label path="travelInfo">Thông tin chuyến đi: </form:label></td>
            <td>
                <form:checkbox path="travelInfo" value="Tàu bay"/>
                Tàu bay
                <form:checkbox path="travelInfo" value="Tàu thuyền"/>
                Tàu thuyền
                <form:checkbox path="travelInfo" value="Ô tô"/>
                Ô tô
                <form:checkbox path="travelInfo" value="Khác(ghi rõ)"/>
                Khác(ghi rõ)
            </td>
        </tr>
        <tr>
            <td><form:label path="vehicleNumber">Số hiệu phương tiện: </form:label></td>
            <td><form:input path="vehicleNumber"/></td>
        </tr>
        <tr>
            <td><form:label path="seatNumber">Số ghế: </form:label></td>
            <td><form:input path="seatNumber"/></td>
        </tr>
        <tr>
            <td><form:label path="departureDate">Ngày khởi hành: </form:label></td>
            <td><form:input path="departureDate"/></td>
        </tr>
        <tr>
            <td><form:label path="endDate">Ngày kết thúc: </form:label></td>
            <td><form:input path="endDate"/></td>
        </tr>
        <tr>
            <td><form:label path="visitedPlaces">Trong 14 ngày qua anh(chị) đã đến những tỉnh nào: </form:label></td>
            <td><form:input path="visitedPlaces"/></td>
        </tr>
        <tr>
            <td><form:label path="address">Địa chỉ: </form:label></td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td><form:label path="city">Tỉnh(Thành phố): </form:label></td>
            <td><form:input path="city"/></td>
        </tr>
        <tr>
            <td><form:label path="phone">Số điện thoại: </form:label></td>
            <td><form:input path="phone"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email: </form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td>
                <p>Trong vòng 14 ngày qua, Anh(chị) có thấy xuất hiệu dấu hiệu nào sau đây không?</p>
            </td>
        </tr>
        <tr>
            <td><form:label path="sot">Sốt</form:label></td>
            <td><form:checkbox path="sot"/></td>
        </tr>
        <tr>
            <td><form:label path="ho">Ho</form:label></td>
            <td><form:checkbox path="ho"/></td>
        </tr>
        <tr>
            <td><form:label path="kho_tho">Khó thở</form:label></td>
            <td><form:checkbox path="dau_hong"/></td>
        </tr>
        <tr>
            <td><form:label path="dau_hong">Đau họng</form:label></td>
            <td><form:checkbox path="dau_hong"/></td>
        </tr>
        <tr>
            <td><form:label path="non_buon_non">Nôn/buồn nôn</form:label></td>
            <td><form:checkbox path="non_buon_non"/></td>
        </tr>
        <tr>
            <td><form:label path="tieu_chay">Tiêu chảy</form:label></td>
            <td><form:checkbox path="tieu_chay"/></td>
        </tr>
        <tr>
            <td><form:label path="xuat_huyet_ngoai_da">Xuất huyết ngoài da</form:label></td>
            <td><form:checkbox path="xuat_huyet_ngoai_da"/></td>
        </tr>
        <tr>
            <td><form:label path="noi_ban_ngoai_da">Nổi ban ngoài da</form:label></td>
            <td><form:checkbox path="noi_ban_ngoai_da"/></td>
        </tr>
        <tr>
            <td>
                <p>Lịch sử phơi nhiễm: Trong vòng 14 ngày qua, Anh(chị) có:</p>
            </td>
        </tr>
        <tr>
            <td><form:label path="phoi_nhiem_1">Đến trang trại chăn nuôi/ chợ buôn bán động vật sống/ tiếp xúc động vật</form:label></td>
            <td><form:checkbox path="phoi_nhiem_1"/></td>
        </tr>
        <tr>
            <td><form:label path="phoi_nhiem_2">Tiếp xúc gần(<2m) với người mắc bệnh viêm đường hô hấp do nCoV</form:label></td>
            <td><form:checkbox path="phoi_nhiem_2"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Gửi tờ khai">
            </td>
        </tr>


    </table>

</form:form>
</body>
</html>
