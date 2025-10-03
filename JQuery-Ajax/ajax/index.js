function addNewSmartPhone() {
    //lấy dữ liệu từ form html
    let producer = $('#producer').val();
    let model = $('#model').val();
    let price = $('#price').val();
    let newSmartphone = {
        producer: producer,
        model: model,
        price: price
    };
    // gọi phương thức ajax
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newSmartphone),
        //tên API
        url: "http://localhost:8080/api/smartphones",
        //xử lý khi thành công
        success: successHandler

    });
    //chặn sự kiện mặc định của thẻ
    event.preventDefault();
}

function successHandler() {
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/smartphones",
        success: function (data) {
            let content = '<table id="display-list" border="1"><tr>' +
                '<th>Producer</th>' +
                '<th>Model</th>' +
                '<th>Price</th>' +
                '<th>Action</th>' +
                '</tr>';
            for (let i = 0; i < data.length; i++) {
                content += getSmartphone(data[i]);
            }
            content += "</table>";
            document.getElementById('smartphoneList').innerHTML = content;
            document.getElementById('smartphoneList').style.display = "block";
            document.getElementById('add-smartphone').style.display = "none";
            document.getElementById('title').style.display = "block";

            document.getElementById('display').style.display = "none";
            document.getElementById('display-create').style.display = "inline-block";
        }
    });
}

function displayFormCreate() {
    document.getElementById('smartphoneList').style.display = "none";
    document.getElementById('add-smartphone').style.display = "block";
    document.getElementById('display-create').style.display = "none";
    document.getElementById('title').style.display = "none";
}

function getSmartphone(smartphone) {
    return `<tr><td >${smartphone.producer}</td><td >${smartphone.model}</td><td >${smartphone.price}</td>` +
        `<td class="btn">
            <button class="deleteSmartphone" onclick="deleteSmartphone(${smartphone.id})">Delete</button>
            <button class="editSmartphone" onclick="editSmartphone(${smartphone.id})">Edit</button>
        </td></tr>`;
}

function deleteSmartphone(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: successHandler
    });
}

function editSmartphone(id) {
    // Gọi API lấy thông tin smartphone theo id
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: function (data) {
            // Gán dữ liệu vào form edit
            $('#edit-id').val(data.id);
            $('#edit-producer').val(data.producer);
            $('#edit-model').val(data.model);
            $('#edit-price').val(data.price);

            // Ẩn danh sách và hiển thị form edit
            document.getElementById('smartphoneList').style.display = "none";
            document.getElementById('add-smartphone').style.display = "none";
            document.getElementById('edit-smartphone').style.display = "block";
            document.getElementById('title').style.display = "none";
        }
    });
}

function updateSmartphone() {
    let id = $('#edit-id').val();
    let producer = $('#edit-producer').val();
    let model = $('#edit-model').val();
    let price = $('#edit-price').val();

    let updatedSmartphone = {
        id: id,
        producer: producer,
        model: model,
        price: price
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(updatedSmartphone),
        url: `http://localhost:8080/api/smartphones/${id}`,
        success: successHandler
    });

    event.preventDefault();
}
function cancelEdit() {
    document.getElementById('edit-smartphone').style.display = "none";
    document.getElementById('smartphoneList').style.display = "block";
    document.getElementById('title').style.display = "block";
}
