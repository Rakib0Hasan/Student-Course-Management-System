function studentsTable() {
	if(event.target.textContent == "View all students"){
		document.getElementById("allStudentsTable").style.display = "block";
		document.getElementById("viewAllStudentsLink").innerHTML = "Hide students table";
	}
	else{
		document.getElementById("allStudentsTable").style.display = "none";
		document.getElementById("viewAllStudentsLink").innerHTML = "View all students";
	}
}

function showTable(){
	if(studentExists){
		document.getElementById("emailStudentTable").style.display = "block";
	}
}
