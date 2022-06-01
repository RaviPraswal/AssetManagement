<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assets</title>
<link
	href="https://cdn.datatables.net/1.11.5/css/dataTables.bootstrap5.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.1.3/css/bootstrap.min.css"
	rel="styleshet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.14.0/css/all.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<style>
.ModelContent {
	background-color: white;
	margin: 5px;
	padding: 10px;
	align-content: flex-end;
	font-size: 1.2vw;
}

.model-header {
	padding: 5px;
	text-align: center;
}

.model-footer {
	padding: 5px;
	text-align: right;
}
</style>

</head>
<body>
	<jsp:include page="navigation.jsp">
		<jsp:param value="asset" name="selectedNav" />
	</jsp:include>
	<div style="overflow-x: auto; width: 100%; font-size: 0.9vw;"
		class="container-fluid">
		<h2
			style="text-align: center; color: #4075DC; text-shadow: 2px 2px 4px #000000; margin-top: 20px; font-size: 35px;">
			Assets</h2>
		<hr>
		<table id="example" class="table ">
			<thead>
				<tr>
					<th>#</th>
					<th>Sku Number</th>
					<th>Name</th>
					<th>Description</th>
					<th>Model</th>
					<th>Purchase date</th>
					<th>Warranty date</th>
					<th>Cost</th>
					<th>Vender</th>
					<th>Bill Number</th>
					<!-- <th>Bill document</th> -->
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${assetList}" var="assetObj">
					<c:if test="${assetObj != null}">
						<tr>
							<td>${assetObj.id}</td>
							<td>${assetObj.skuNumber}</td>
							<td>${assetObj.name}</td>
							<td>${assetObj.description}</td>
							<td>${assetObj.model}</td>
							<td>${assetObj.purchaseDate}</td>
							<td>${assetObj.waranty}</td>
							<td>${assetObj.cost}</td>
							<td>${assetObj.vendor}</td>
							<td>${assetObj.billNo}</td>
							<%-- <td><c:if test="${assetObj.fileName}">
							<i class='fas fa-file-upload' style='color: blue'></i>
							</c:if> --%>

							</td>

							<td style="display: inline-flex; font-size: 0.9vw;"><a
								href='open_update_form?assetId=${assetObj.id}'
								class="btn btn-secondary fa fa-edit"
								style="margin-left: 5px; font-size: 0.9vw;">Edit</a>
								<button type="button" class="btn btn-danger fa fa-trash"
									data-bs-toggle="modal" data-bs-target="#deleteAsset"
									style="margin-left: 5px; font-size: 0.9vw;"
									onclick="showModal(${assetObj.id})">Delete</button></td>
						</tr>
					</c:if>
				</c:forEach>

			</tbody>

		</table>
	</div>
	<!--  add assets code -->
	<a href="open_asset_view" class="btn btn-primary"
		style="margin: 50px; margin-left: 45%; font-size: 0.9vw;">Create
		New</a>


	<!-- delete asset code start here  -->
	<!-- Modal -->
	<div class="modal fade" id="deleteAsset">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="model-header">
					<h4>Delete Assets</h4>
				</div>

				<div class="modal-body fa-solid fa-circle-question">Are you
					sure you want to delete this item?</div>
				<hr>
				<form action="delete_asset" id="delete-data">
					<div class="row mb-3 ml-2">
						<label for="id" class="col-md-3 col-form-label"
							style="display: none;">Id : </label>
						<div class="col-md-8" style="display: none;">
							<input class="form-control form-control-sm" name="id">
						</div>
						<div class="model-footer">
							<button type="button" class="btn btn-dark"
								data-bs-dismiss="modal" style="font-size: 1vw;">No</button>
							<button type="submit" class="btn btn-primary"
								style="font-size: 1vw;">Yes</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>








	<!-- JavaScript -->

	


	<script>
		function showModal(assetId){			
			document.getElementById("delete-data").id.value=assetId;
			$("#deleteAsset").modal("show");

			}
</script>
	<!-- end delete asset code here -->

	<!-- table scripting code -->
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
	<!-- <script type="text/javascript">
	
	var deletedAssetById="${param.deletedAssetById}";
	if(deletedAssetById==false){
		swal("Sorry!","This cannot be deleted..","error");
	}else{
		swal("Deleted","delete successfully..","success");
	}
	
	</script> -->
	<%@ include file="footer.jsp"%>
</body>
</html>