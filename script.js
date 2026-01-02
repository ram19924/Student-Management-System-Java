let studentList = [];

function addStudent() {
    let id = document.getElementById("sid").value;
    let name = document.getElementById("sname").value;
    let age = document.getElementById("sage").value;
    let course = document.getElementById("scourse").value;

    if (id === "" || name === "" || age === "" || course === "") {
        alert("Please fill all fields");
        return;
    }

    let student = {
        id: id,
        name: name,
        age: age,
        course: course
    };

    studentList.push(student);
    showStudents();
    clearInputs();
}

function showStudents() {
    let table = document.getElementById("tableBody");
    table.innerHTML = "";

    for (let i = 0; i < studentList.length; i++) {
        table.innerHTML += `
            <tr>
                <td>${studentList[i].id}</td>
                <td>${studentList[i].name}</td>
                <td>${studentList[i].age}</td>
                <td>${studentList[i].course}</td>
                <td>
                    <button onclick="deleteStudent(${i})">Delete</button>
                </td>
            </tr>
        `;
    }
}

function deleteStudent(index) {
    studentList.splice(index, 1);
    showStudents();
}

function updateStudent() {
    let id = document.getElementById("sid").value;

    for (let i = 0; i < studentList.length; i++) {
        if (studentList[i].id === id) {
            studentList[i].name = document.getElementById("sname").value;
            studentList[i].age = document.getElementById("sage").value;
            studentList[i].course = document.getElementById("scourse").value;

            showStudents();
            clearInputs();
            return;
        }
    }

    alert("Student not found");
}

function clearInputs() {
    document.getElementById("sid").value = "";
    document.getElementById("sname").value = "";
    document.getElementById("sage").value = "";
    document.getElementById("scourse").value = "";
}
