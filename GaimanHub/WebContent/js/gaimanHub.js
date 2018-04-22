/**
 * 
 */
$(document).ready(function(){
	$.ajax({
		type:"GET",
		url:"/GaimanHubService/books",
		dataType: "JSON",
		success: function(data){
			var bookList = data.books;
			bookList.sort(function(book1,book2){
				return book1.title > book2.title ? 1 : -1;
			});
			$.each(bookList, function(i,value){
				$("#results").append(
					"<div id='result-row' class='row'>" +
						"<div class='col-2'>" +
						"	<div class='rsp-header'>Title</div>" +
						"	<div id='row-content'>" + value.title + "</div>" +
						"</div>" +
						"<div class='col-2'>" + 
						"	<div class='rsp-header'>Author(s)</div>" +
						"   <div id='row-content'>" + value.authors + "</div>" +
						"</div>" +
						"<div class='col-2'>" + 
						"	<div class='rsp-header'>Original Publish Date</div>" +
						"   <div id='row-content'>" + value.originalPublishDate + "</div>" +
						"</div>" +
						"<div class='col-2'>" + 
						"	<div class='rsp-header'>Publisher</div>" +
						"   <div id='row-content'>" + value.publisher + "</div>" +
						"</div>" +
						"<div class='col-2'>" + 
						"	<div class='rsp-header'>ISBN</div>" +
						"   <div id='row-content'>" + value.isbn + "</div>" +
						"</div>" +
						"<div class='col-2'>" +
						"	<div class='rsp-header'>Read</div>" +
						"   <div id='row-content'><a href='" + value.openLibraryLink + "'>Open Library</a></div>" +
						"</div>" +
					"</div>"
				)
			});
		},
		error: function(data){
			window.location.href = "/GaimanHub/error";
		}
	});
	
	$("#submitButton").click(function(){
		var nameFilter = $("#titleFilter").val();
		if(nameFilter == ""){
			alert("Must enter a value.");
			return;
		}
		$("#results").empty();
		$.ajax({
			type:"GET",
			url:"/GaimanHubService/books/search?name=" + nameFilter,
			dataType: "JSON",
			success: function(data){
				var bookList = data.books;
				bookList.sort(function(book1,book2){
					return book1.title > book2.title ? 1 : -1;
				});
				$.each(bookList, function(i,value){
					$("#results").append(
							"<div id='result-row' class='row'>" +
							"<div class='col-2'>" +
							"	<div class='rsp-header'>Title</div>" +
							"	<div id='row-content'>" + value.title + "</div>" +
							"</div>" +
							"<div class='col-2'>" + 
							"	<div class='rsp-header'>Author(s)</div>" +
							"   <div id='row-content'>" + value.authors + "</div>" +
							"</div>" +
							"<div class='col-2'>" + 
							"	<div class='rsp-header'>Original Publish Date</div>" +
							"   <div id='row-content'>" + value.originalPublishDate + "</div>" +
							"</div>" +
							"<div class='col-2'>" + 
							"	<div class='rsp-header'>Publisher</div>" +
							"   <div id='row-content'>" + value.publisher + "</div>" +
							"</div>" +
							"<div class='col-2'>" + 
							"	<div class='rsp-header'>ISBN</div>" +
							"   <div id='row-content'>" + value.isbn + "</div>" +
							"</div>" +
							"<div class='col-2'>" +
							"	<div class='rsp-header'>Read</div>" +
							"   <div id='row-content'><a href='" + value.openLibraryLink + "'>Open Library</a></div>" +
							"</div>" +
						"</div>"
					)
				});
			},
			error: function(data){
				window.location.href = "/GaimanHub/error";
			}
		});
	});
	
	$("#titleFilter").keypress(function (e) {
		 var key = e.which;
		 if(key == 13)
		  {
		    $("#submitButton").click();
		    return false;  
		  }
	});  
	
});