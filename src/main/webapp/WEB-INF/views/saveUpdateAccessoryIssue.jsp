<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AccessoryIssue</title>
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
	<!-- The Modal -->
	<div class="modal fade" id="edit-modal-content"
		style="width: 100%; font-size: 1vw; font-weight: bold;">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="model-header">
					<h3>Accessory Issue</h3>
				</div>
				<hr>
				<!-- Modal body -->
				<div class="modal-body">
					<div class="container">
						<form:form action="save_update_accessory_issue" method="post"
							modelAttribute="accessoryIssues">

							<div class="row mb-3">
								<c:if test="${ accessoryIssues!=null}">
									<label for="id" class="col-md-3 col-form-label" style="display: none;">Id :</label>
									<div class="col-md-9">
										<input type="hidden"class="form-control form-control-sm" readOnly name="id"
											id="id" value="${accessoryIssues.id} ">
									</div>
								</c:if>
							</div>
							<div class="row mb-2">
								<label for="accessory" class="col-md-3 col-form-label">Accessory:</label>
								<div class="col-md-9">
									<form:select class=" form-select form-select-sm" path="accessory.id">
										<option selected disabled value="" >Select Accessory</option>
										<c:forEach items="${loadAccessory}" var="loadAccessoryObj">
											<c:if test="${loadAccessoryObj!=null}">
												<form:option value="${loadAccessoryObj.id }" label="${loadAccessoryObj.name}"></form:option>
											</c:if>
										</c:forEach>
									</form:select>

								</div>
							</div>
							<div class="row mb-2">
								<label for="issuedToEmployee" class="col-md-3 col-form-label">Issue
									To(Employee) :</label>
								<div class="col-md-9" style="display: inline-flex;">
								<input type="radio" name="type" value="employee" style="margin-top: 10px;" >
									<form:select class="form-select  form-select-sm" path="issuedToEmployee.employeeId" id="issuedToEmployee" disabled = "${true}">
										<option selected disabled value="" >Select Employee</option>
										<c:forEach items="${loadEmployee}" var="loadEmployeeObj">
											<c:if test="${loadEmployeeObj!=null}">
												<form:option value="${loadEmployeeObj.employeeId}"
													label="${loadEmployeeObj.firstName}"></form:option>
											</c:if>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="row mb-1">
								<label for="issuedToNonEmployee" class="col-md-3 col-form-label">Issue
									To (Non-Employee) :</label>
								<div class="col-md-9" style="display: inline-flex;">
								<input type="radio" name="type"value="employee"style="margin-top: 10px;" >
									<input type="text" class="form-control form-control-sm"
										value="${accessoryIssues.issuedToNonEmployee} "
										id="issuedToNonEmployee" name="issuedToNonEmployee"disabled="true">
								</div>
							</div>
							<div class="row mb-2">
								<label for="issueDate" class="col-md-3 col-form-label">Issue
									Date :</label>
								<div class="col-md-9">
									<input type="date" class="form-control form-control-sm"
										value="${accessoryIssues.issueDate}" name="issueDate"
										id="issueDate">
										<form:errors path="issueDate" cssClass="error"/>
								</div>

								<label for="issueQuantity" class="col-md-3 col-form-label">Issue
									Qty:</label>
								<div class="col-md-9" style="margin-top: 10px;">
									<input type="text" class="form-control form-control-sm"
										value="${accessoryIssues.issueQuantity} " id="issueQuantity"
										name="issueQuantity">
										<form:errors path="issueQuantity" cssClass="error"/>
								</div>
							</div>
							<div class="row mb-1">
								<label for="remark" class="col-md-3 col-form-label">Remark
									Purpose :</label>
								<div class="col-md-9">
									<textarea rows="5" class="form-control form-control-sm"
										required placeholder="${accessoryIssues.remark}" name="remark"
										id="remark"></textarea>

								</div>
							</div>
							<hr>
							<!-- Modal footer -->
							<div class="model-footer">
								<a href="../admin/accessory_issues_view"
									class="btn btn-secondary " style="font-size: 1vw;">Close</a>

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
			$("#edit-modal-content").modal('show');
		});
	</script>
	<script>
	document.getElementsByTagName('input')[1].addEventListener('click', function() {
		  document.getElementById('issuedToEmployee').removeAttribute('disabled',false);
		  document.getElementById('issuedToNonEmployee').setAttribute('disabled', true);
		});	
		document.getElementsByTagName('input')[2].addEventListener('click', function() {
		  document.getElementById('issuedToNonEmployee').removeAttribute('disabled',false);
		  document.getElementById('issuedToEmployee').setAttribute('disabled', true);
		});
	</script>
</body>
</html>