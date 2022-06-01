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
					<th>Bill document</th>
					<th style="display: none;">Asset Type</th>
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
							<td>
								<!-- <i class='fas fa-file-upload fa-spin fa-2x'></i> --> <span
								class='fa-stack fa-lg'> <i
									class='fas fa-file-upload  fa-stack-1x'></i> <i
									class='fas fa-ban fa-stack-2x'></i>
							</span>
							</td>
							<td style="display: none;">${assetObj.assetType}</td>
							<td style="display: inline-flex; font-size: 0.9vw;"><a
								href='open_update_form?assetId=${assetObj.id}'
								class="btn btn-secondary fa fa-edit" id="editAssets"
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
	<button type="button" class="btn btn-primary" data-bs-toggle="modal"
		data-bs-target="#addAssets"
		style="margin: 50px; margin-left: 45%; font-size: 0.9vw;">Create
		New</button>

	<!-- The Modal -->
	<div class="modal fade" id="addAssets"
		style="width: 100%; font-size: 1vw; font-weight: bold;">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="model-header">
					<h3 class=" modal-title">Add Assets</h3>
				</div>
				<hr>
				<!-- Modal body -->
				<div class="modal-body">

					<form:form action="save_asset">

						<div class="row mb-2">
							<label for="skuNumber" class="col-md-2 col-form-label">Sku
								Number :</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									placeholder=" sku number" name="skuNumber" id="skuNumber">
							</div>

							<label for="purchaseDate" class="col-md-2 col-form-label">Purchase
								Date :</label>
							<div class="col-md-4">
								<input type="date" class="form-control form-control-sm"
									name="purchaseDate" id="purchaseDate">
							</div>
						</div>
						<div class="row mb-2">
							<label for="name" class="col-md-2 col-form-label">Name :</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									placeholder="name" id="name" name="name">
							</div>
							<label for="waranty" class="col-md-2 col-form-label">Warranty
								Date :</label>
							<div class="col-md-4">
								<input type="date" class="form-control form-control-sm"
									name="waranty" id="waranty">
							</div>
						</div>
						<div class="row mb-2">
							<label for="description" class="col-md-2 col-form-label">Description
								:</label>
							<div class="col-md-4">
								<textarea class="form-control form-control-sm"
									placeholder="enter description" name="description"
									id="description"></textarea>
							</div>

							<label for="cost" class="col-md-2 col-form-label">Cost :</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									placeholder="0" id="cost" name="cost">
							</div>
						</div>
						<div class="row mb-2">
							<label for="vendor" class="col-md-2 col-form-label">Vender
								:</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									placeholder="enter vender" id="vendor" name="vendor">
							</div>


							<label for="billNo" class="col-md-2 col-form-label">Bill
								Number :</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									placeholder="enter bill number" name="billNo" id="billNo">
							</div>
						</div>
						<div class="row mb-2">
							<label for="model" class="col-md-2 col-form-label">Model
								:</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									name="model" id="model" placeholder="enter model">
							</div>
							<label for="model" class="col-md-2 col-form-label">Assets
								Type: </label>
							<div class="col-md-4">
								<select class="form-select mt-3 form-select-sm" name="assetType">
									<option selected disabled value="">select type</option>
									<c:forEach items="${assetTypeList}" var="assetTypeListObj">
										<c:if test="${assetTypeListObj!=null}">
											<option value="${assetTypeListObj.typeName }">${assetTypeListObj.typeName}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="row mb-2">
							<label for="parentType" class="col-md-2 col-form-label">Parent
								Type: </label>
							<div class="col-md-4">
								<select class="form-select  form-select-sm" required
									name="parentType">
									<option selected disabled value="">select parents type</option>
									<option value="Computer">Computer</option>
									<option value="Laptop">Laptop</option>
								</select>
							</div>
							<label for="billdocument" class="col-md-2 col-form-label">Bill
								Document : </label>
							<div class="col-md-4">
								<input type="file" class="form-control form-control-sm"
									placeholder="" name="billDocument">
							</div>
						</div>
						<hr>
						<!-- Modal footer -->
						<div class="model-footer">
							<button type="button" class="btn btn-secondary "
								data-bs-dismiss="modal" style="font-size: 1vw;">Close</button>
							<button type="submit" class="btn btn-primary"
								style="font-size: 1vw;">save</button>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
	<!--  end add assets code-->


	<!-- delete asset code start here  -->
	<!-- Modal -->
	<div class="modal fade" id="deleteAsset">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="model-header">
					<h4 class="modal-title">Delete Assets</h4>
				</div>
				<hr>
				<div class="modal-body">Are you sure delete this asset..</div>
				<form action="delete_asset" id="delete-data">
					<div class="row mb-3 ml-2">
						<label for="id" class="col-md-3 col-form-label"
							style="display: none;">Id : </label>
						<div class="col-md-8">
							<input type="hidden" class="form-control form-control-sm"
								name="id">
						</div>
						<hr>
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
	<script>
	var navId = "${param.selectedNav}";
	var nav = document.getElementById(navId)
      $(document).ready(function(){
          $(nav).modal('show');
      });
  </script>
	<!-- <script>
	$(document).ready(function(){
	    $('#skuNumber').change(function(){
	        var uname = $(this).val();
	        $.ajax({
	            type: "POST",
	            url: "save_asset",
	            data: {"uname": uname},
	            success: function(flag){
	                  if(flag == 'showAlert')
	                    alert("OK");
	                  else
	                    alert("User name exists !... try another");*//*

	                alert(msg + uname);


	            },
	            error:function(){
	                alert("ajax failed" +uname);
	            }
	        });

	    });
	});
  </script> -->
	<%@ include file="footer.jsp"%>
</body>
</html>