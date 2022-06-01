<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Assets</title>
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
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script
	src="https://cdn.datatables.net/1.11.5/js/jquery.dataTables.min.js"></script>
<script
	src="https://cdn.datatables.net/1.11.5/js/dataTables.bootstrap5.min.js"></script>
<style>
.model-header {
	padding: 5px;
	text-align: center;
}

.model-footer {
	padding: 5px;
	text-align: right;
}

.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<!-- edit asset code here start -->

	<div class="modal fade" id="editAssets"
		style="width: 100%; font-size: 1vw; font-weight: bold;">
		<div class="modal-dialog modal-xl">
			<div class="modal-content">
				<div class="model-header">
					<h3 class=" modal-title">Assets</h3>
				</div>
				<hr>
				<!-- Modal body -->
				<div class="modal-body">
					<form:form
						action="save_update_asset?${_csrf.parameterName}=${_csrf.token}"
						method="POST" modelAttribute="asset" enctype="multipart/form-data">
						<c:if test="${asset!=null }">
							<div class="row mb-2">
								<label for="id" class="col-md-2 col-form-label"
									style="display: none;">Id :</label>
								<div class="col-md-10">
									<input type="hidden" class="form-control form-control-sm"
										value="${asset.id}" name="id" id="id" readonly>
								</div>
							</div>
						</c:if>
						<div class="row mb-2">

							<form:label path="skuNumber" for="skuNumber"
								class="col-md-2 col-form-label">Sku
								Number :</form:label>
							<div class="col-md-4">
								<form:input type="text" class="form-control form-control-sm"
									value="${asset.skuNumber}" path="skuNumber" name="skuNumber"
									id="skuNumber" />
								<form:errors path="skuNumber" cssClass="error" />
							</div>

							<label for="purchaseDate" class="col-md-2 col-form-label">Purchase
								Date :</label>
							<div class="col-md-4">
								<input type="date" class="form-control form-control-sm"
									value="${asset.purchaseDate}" name="purchaseDate"
									id="purchaseDate">
								<form:errors path="purchaseDate" cssClass="error" />
							</div>
						</div>
						<div class="row mb-2">
							<label for="name" class="col-md-2 col-form-label">Name :</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									value="${asset.name}" id="name" name="name">
								<form:errors path="name" cssClass="error" />
							</div>
							<label for="waranty" class="col-md-2 col-form-label">Warranty
								Date :</label>
							<div class="col-md-4">
								<input type="date" class="form-control form-control-sm"
									value="${asset.waranty}" name="waranty" id="waranty">
								<form:errors path="waranty" cssClass="error" />
							</div>
						</div>
						<div class="row mb-2">
							<label for="description" class="col-md-2 col-form-label">Description
								:</label>
							<div class="col-md-4">
								<textarea class="form-control form-control-sm"
									placeholder="${asset.description}" name="description"
									id="description" ></textarea>
							</div>

							<label for="cost" class="col-md-2 col-form-label">Cost :</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									value="${asset.cost}" id="cost" name="cost" />
								<form:errors path="cost" cssClass="error" />
							</div>
						</div>
						<div class="row mb-2">
							<label for="vendor" class="col-md-2 col-form-label">Vender
								:</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									value="${asset.vendor}" id="vendor" name="vendor">
								<form:errors path="vendor" cssClass="error" />
							</div>


							<label for="billNo" class="col-md-2 col-form-label">Bill
								Number :</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									value="${asset.billNo}" name="billNo" id="billNo">
								<form:errors path="billNo" cssClass="error" />
							</div>
						</div>
						<div class="row mb-2">
							<label for="model" class="col-md-2 col-form-label">Model
								:</label>
							<div class="col-md-4">
								<input type="text" class="form-control form-control-sm"
									value="${asset.model}" name="model" id="model">
								<form:errors path="model" cssClass="error" />
							</div>
							<label for="model" class="col-md-2 col-form-label">Assets
								Type: </label>
							<div class="col-md-4">
								<form:select class="form-select  form-select-sm"
									path="assetType.id" name="at">
									<%-- <form:option selected disabled value="">select type</form:option> --%>
									<c:forEach items="${assetTypeList}" var="assetTypeListObj">
										<c:if test="${assetTypeListObj!=null}">
											<form:option value="${assetTypeListObj.id}"
												label="${assetTypeListObj.typeName}"></form:option>
										</c:if>
									</c:forEach>
								</form:select>
								<%-- <form:errors path="at" cssClass="error" /> --%>
							</div>
						</div>

						<div class="row mb-2">
							<label for="parentAsset" class="col-md-2 col-form-label">Parent
								Asset: </label>
							<div class="col-md-4">
								<%-- <select class="form-select mt-3 form-select-sm"
									name="parentType">
									<option value="${asset.parentType}">"${asset.parentType}"</option>
									<option value="Computer">Computer</option>
									<option value="Laptop">Laptop</option>
								</select> --%>
								
								<form:select class="form-select  form-select-sm"
										path="parentAsset">
										<option selected disabled value="">select type</option>
										<c:forEach items="${parentAssetList}" var="parentAsset">
											<c:if test="${parentAsset!=null}">
												<form:option value="${parentAsset}"
													label="${parentAsset}"></form:option>
											</c:if>
										</c:forEach>
									</form:select>
								
								<form:errors path="parentAsset" cssClass="error" />
							</div>
							<form:label class="col-md-2 col-form-label" path="file">Bill
								Document : </form:label>
							<div class="col-md-4">
								<!-- Bill document: -->
								<input type="file" class="form-control form-control-sm"
									name="file">
									<%-- <form:errors path="file" cssClass="error" /> --%>
							</div>
						</div>
						<hr>
						<!-- Modal footer -->
						<div class="model-footer">
							<a href="../home/asset_view" class="btn btn-secondary "
								style="font-size: 1vw;">Close</a>
							<button type="submit" class="btn btn-primary"
								style="font-size: 1vw;">save</button>
						</div>
					</form:form>

				</div>
			</div>
		</div>
	</div>
	<!--  here end code of edit asset-->
	<script type="text/javascript">
		$(document).ready(function() {
			$("#editAssets").modal('show');
		});
	</script>
</body>
</html>