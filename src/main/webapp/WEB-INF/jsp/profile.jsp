<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/images/favicon.ico">
<title>Profile</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
	<header>
		<jsp:include page="common/header.jsp" />
	</header>
	
	<main>
		<aside class="left-sidebar">
			<p>This is left sidebar.</p>
		</aside>
		
		<section class="main-content">
			
			<div id="profileId" class="profile">
			
				<form action="${pageContext.request.contextPath}/uploadUserProfilePictuerServlet" target="_self" method="post" enctype="multipart/form-data">
					<div id="profilePictureId" class="profilePicture">
						<label for="profileInputImageId" id="profileInputImageLabelId">
							<input type="file" accept="image/*" id="profileInputImageId" hidden>
							<div id="previewImage">
								<img src="${pageContext.request.contextPath}/images/imageUploader_Colored.png">
								<p>Drag and drop or click here<br>to upload image.</p>
							</div>
						</label>
					</div>
					<input type="hidden" name="userEmail" value="${user.email}"><br>
					<button type="submit" class="btn" id="profileImageUploadId">Upload</button>
				</form>
				
				<div class=informationSeperator>
				
				</div>
				
				<div class="persionalInfo">
					
				</div>
				
			</div>
		</section>
		
		<aside class="right-sidebar">
			<p>This is right sidebar</p>
		</aside>
	</main>
	
	<footer>
		<jsp:include page="common/footer.jsp" />
	</footer>
</body>
<script src="${pageContext.request.contextPath}/js/script.js"></script>
</html>