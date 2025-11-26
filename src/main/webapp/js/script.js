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

const dropArea = document.getElementById("profileInputImageLabelId");
const inputFile = document.getElementById("profileInputImageId");
const previewImage = document.getElementById("previewImage");

inputFile.addEventListener("change", uploadImage);

function uploadImage() {
	let imageLink = URL.createObjectURL(inputFile.files[0]);
	previewImage.style.backgroundImage = `url(${imageLink})`;
	previewImage.textContent = "";
}

dropArea.addEventListener("dragover", function(e){
	e.preventDefault();
});

dropArea.addEventListener("drop", function(e){
	e.preventDefault();
	inputFile.files = e.dataTransfer.files;
	uploadImage();
});

