<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>saveUpdate Accessory</title>
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

.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<!-- The Modal -->
	<div class="modal fade" id="open_update_accessory_form"
		style="width: 100%; font-size: 1vw; font-weight: bold;">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="model-header">
					<h3>Accessory</h3>
				</div>
				<hr>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="container">
						<form:form
							action="save_update_accessory?${_csrf.parameterName}=${_csrf.token}"
							method="post" modelAttribute="accessory"
							enctype="multipart/form-data">
							<c:if test="${accessory!=null }">
								<div class="row mb-2">
									<label for="id" class="col-md-2 col-form-label"
										style="display: none;">Id :</label>
									<div class="col-md-10">
										<input type="hidden" class="form-control form-control-sm"
											id="id" name="id" placeholder="" value="${accessory.id}"
											readOnly>
									</div>
								</div>
							</c:if>
							<div class="row mb-2">
								<label for="skuNumber" class="col-md-2 col-form-label">Sku
									Number :</label>
								<div class="col-md-4">
									<input type="text" class="form-control form-control-sm"
										value="${accessory.skuNumber}" name="skuNumber" id="skuNumber">
									<form:errors path="skuNumber" cssClass="error" />
								</div>
								<label for="UnitCost" class="col-md-2 col-form-label">Unit
									Cost :</label>
								<div class="col-md-4">
									<input type="text" class="form-control form-control-sm"
										id="cost" name="cost" value="${accessory.cost}">
									<form:errors path="cost" cssClass="error" />
								</div>

							</div>
							<div class="row mb-2">
								<label for="name" class="col-md-2 col-form-label">Name :</label>
								<div class="col-md-4">
									<input type="text" class="form-control form-control-sm"
										id="name" name="name" value="${accessory.name}">
									<form:errors path="name" cssClass="error" />
								</div>
								<label for="purchaseQuantity" class="col-md-2 col-form-label">
									Purchase Qty :</label>
								<div class="col-md-4">
									<input type="text" class="form-control form-control-sm"
										name="purchaseQuantity" value="${accessory.purchaseQuantity}">
									<form:errors path="purchaseQuantity" cssClass="error" />
								</div>
							</div>
							<div class="row mb-2">

								<label for="model" class="col-md-2 col-form-label">Type:
								</label>
								<div class="col-md-4">
									<form:select class="form-select form-select-sm"
										path="accessoryType.id">
										<c:forEach items="${loadAccessoryTypes}"
											var="loadAccessoryTypesObj">
											<c:if test="${loadAccessoryTypesObj!=null}">
												<form:option value="${loadAccessoryTypesObj.id }"
													label="${loadAccessoryTypesObj.typeName}"></form:option>
											</c:if>
										</c:forEach>
									</form:select>
									<%-- <form:errors path="purchaseQuantity" cssClass="error" /> --%>
								</div>
								<label for="vender" class="col-md-2 col-form-label">Vender:</label>
								<div class="col-md-4">
									<input type="text" class="form-control form-control-sm"
										value="${accessory.vendor}" id="vendor" name="vendor">
									<form:errors path="vendor" cssClass="error" />
								</div>
							</div>

							<div class="row mb-2">
								<label for="billNumber" class="col-md-2 col-form-label">Bill
									No :</label>
								<div class="col-md-4">
									<input type="text" class="form-control form-control-sm"
										id="billNumber" name="billNumber"
										value="${accessory.billNumber }">
									<form:errors path="billNumber" cssClass="error" />
								</div>
								<form:label for="billdocument" class="col-md-2 col-form-label"
									path="file">Bill
									Document : </form:label>
								<div class="col-md-4">
									<input type="file" class="form-control form-control-sm"
										value="${accessory.file}" id="file" name="file">
									<form:errors path="file" cssClass="error" />
								</div>
							</div>
							<div class="row mb-2">
								<label for="desc" class="col-md-2 col-form-label">Description
									:</label>
								<div class="col-md-4">
									<textarea rows="4" class="form-control form-control-sm"
										placeholder="${accessory.description}" name="description"
										id="description"></textarea>
								</div>
								<label for="purdate" class="col-md-2 col-form-label">Purchase
									Date :</label>
								<div class="col-md-4">
									<input type="date" class="form-control form-control-sm"
										value="${accessory.purchaseDate}" name="purchaseDate"
										id="purchaseDate">
									<form:errors path="purchaseDate" cssClass="error" />
								</div>
							</div>
							<hr>
							<!-- Modal footer -->
							<div class="model-footer">
								<a href="../admin/accessory_view" class="btn btn-secondary "
									style="font-size: 1vw;">Close</a>
								<button type="submit" class="btn btn-primary"
									style="font-size: 1vw;">save</button>
							</div>


						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#open_update_accessory_form").modal('show');
		});
	</script>
</body>
</html>