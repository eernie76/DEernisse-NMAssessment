<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gaiman Hub</title>
<link href="css/GaimanHub.css" rel="stylesheet" />
<script src="js/jquery-3.3.1.min.js" ></script>
<script src="js/gaimanHub.js" ></script>
</head>
<body>
	<div id="header" class="row">
		<div id="header-img" class="col-12"><img id="header-img" alt="Neil says hi" src="img/GaimanHub-Mobile.png" /></div>
	</div>
	<div id="search" class="row">
		<div id="filler" class="col-8" ></div>
		<div id="search-input" class="col-4">
			<div class="search-text">Search By Title (use * for partial matches):</div><br>
			<div class="search-input"><input id="titleFilter" type="text" size="30" />&nbsp;<button id="submitButton" type="button">Submit</button></div>
		</div>
	</div>
	<div id="result-header" class="row">
		<div id="Title" class="col-2">Title</div>
		<div id="Authors" class="col-2">Author(s)</div>
		<div id="Original Publish Date" class="col-2">Original Publish Date</div>
		<div id="Publisher" class="col-2">Publisher</div>
		<div id="isbn" class="col-2">ISBN</div>
		<div id="openLibraryLink" class="col-2"><a>Read</a></div>
	</div>
	<div id="results">
	</div>
</body>
</html>