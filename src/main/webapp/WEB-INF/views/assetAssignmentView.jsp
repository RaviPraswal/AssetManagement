
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asset Assignment</title>
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
			Asset Assignment</h2>
		<hr>
		<table id="example" class="table ">
			<thead>
				<tr>
					<th>#</th>
					<th>Asset</th>
					<th>Employee</th>
					<th>Issue Date</th>
					<th>Issue Condition</th>
					<th>Return date</th>
					<th>Return Condition</th>
					<th>Status</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${assetAssignmentList}"
					var="assetAssignmentListObj">
					<c:if test="${assetAssignmentListObj !=null}">
						<tr>
							<td>${assetAssignmentListObj.id}</td>
							<td>${assetAssignmentListObj.asset.name}</td>
							<td>${assetAssignmentListObj.employee.firstName}</td>
							<td>${assetAssignmentListObj.issueDate}</td>
							<td>${assetAssignmentListObj.issueCondition}</td>
							<td>${assetAssignmentListObj.returnDate}</td>
							<td>${assetAssignmentListObj.returnCondition}</td>
							<td>${assetAssignmentListObj.status}</td>
							<td style="display: inline-flex; font-size: 0.9vw;"><a
								href='open_update_asset_assignment_form?assetAssignmentId=${assetAssignmentListObj.id}'
								class="btn btn-secondary fa fa-edit"
								style="margin-left: 5px; font-size: 0.9vw;">Edit</a>
								<button type="button" class="btn btn-danger fa fa-trash"
									data-bs-toggle="modal" data-bs-target="#deleteAssetAssignment" onclick="showModal(${assetAssignmentListObj.id})"
									style="margin-left: 5px; font-size: 0.9vw;">Delete</button></td>
						</tr>
					</c:if>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!--  add assets code -->
	<a href="open_asset_assignemnt" class="btn btn-primary" 
		style="margin: 50px; margin-left: 45%; font-size: 0.9vw;">Create
		New</a>

	<!-- The Modal -->
	<%-- <div class="modal fade" id="addAssetAssignment"
		style="width: 100%; font-size: 1vw; font-weight: bold;">
		<div class="modal-dialog modal-lg"role="document">
			<div class="modal-content">
				<div class="model-header">
					<h3 class=" modal-title">Add Asset Assignment</h3>
				</div>
				<hr>
				<!-- Modal body -->
				<div class="modal-body">
					<form action="save_asset_assignment">
						<div class="row">
							<div class="col-md-6">
								<div class="row mb-1">
									<label for="accessory" class="col-md-4 col-form-label">Asset
										:</label>
									<div class="col-md-8">
										<select class="  form-select form-select-sm" name="asset">
											<c:forEach items="${loadAsset}" var="loadAssetObj">
												<c:if test="${loadAssetObj!=null}">
													<option value="${loadAssetObj.name}">${loadAssetObj.name}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="row mb-1">
									<label for="employee" class="col-md-4 col-form-label">Employee
										:</label>
									<div class="col-md-8">
										<select class="form-select  form-select-sm" name="employee">
											<c:forEach items="${loadEmployee}" var="loadEmployeeObj">
												<c:if test="${loadEmployeeObj!=null}">
													<option value="${loadEmployeeObj.firstName }">${loadEmployeeObj.firstName}</option>
												</c:if>
											</c:forEach>
										</select>
									</div>
								</div>
								<div class="row mb-1">
									<label for="issueDate" class="col-md-4 col-form-label">Issue
										Date :</label>
									<div class="col-md-8">
										<input type="date" class="form-control form-control-sm"
											placeholder="Issue Date" id="issueDate" name="issueDate">
									</div>
								</div>
								<div class="row mb-1">
									<label for="issueCondition" class="col-md-4 col-form-label">IssueCondition:</label>
									<div class="col-md-8">
										<select class="form-select  form-select-sm" name="issueCondition" id="issueCondition">
											<option selected disabled value="">select Issue
												Condition</option>
											<option value="right">right</option>
											<option value="wrong">wrong</option>
										</select>
									</div>
								</div>
								<div class="row mb-1">

									<label for="issueRemark" class="col-md-4 col-form-label">Issue
										Remark :</label>
									<div class="col-md-8">
										<textarea rows="4" class="form-control form-control-sm"
											placeholder="Issue Remark" name="issueRemark" id="issueRemark"></textarea>
									</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="row mb-1">
									<label for="returnDate" class="col-md-4 col-form-label">Return
										Date :</label>
									<div class="col-md-8">
										<input type="date" class="form-control form-control-sm"
											placeholder="Retuen Date"  id="returnDate"name="returnDate">
									</div>
								</div>
								<div class="row mb-1">
									<label for="returnCondition" class="col-md-4 col-form-label">ReturnCondition</label>
									<div class="col-md-8">
										<select class="form-select  form-select-sm" name="returnCondition" id="returnCondition">
											<option selected disabled value="">select Return
												Condition</option>
											<option value="right">right</option>
											<option value="wrong">wrong</option>
										</select>
									</div>
								</div>
								<div class="row mb-1">
									<label for="reruntRemark" class="col-md-4 col-form-label">Return
										Remark:</label>
									<div class="col-md-8">
										<textarea class="form-control form-control-sm" rows="4"
											placeholder="Return Remark" name="reruntRemark" id="reruntRemark"></textarea>
									</div>
								</div>
							</div>
						</div>
						<hr>

						<div class="model-footer">
							<button type="button" class="btn btn-secondary "
								data-bs-dismiss="modal" style="font-size: 1vw;">Close</button>
							<button type="submit" class="btn btn-primary"
								style="font-size: 1vw;">save</button>
						</div>

					</form>

				</div>
			</div>
		</div>
	</div> --%>
	<!--  end add assets code-->
	<!-- Modal -->
	<div class="modal fade" id="deleteAssetAssignment">
		<div class="modal-dialog modal-dialog-centered">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Delete Assets</h4>
				</div>

				<div class="modal-body">Are you sure delete this asset..</div>
				<form action="delete_asset_assignment" id="delete-data">
					<div class="row mb-3 ml-2">
						<label for="id" class="col-md-3 col-form-label" style="display: none;">Id : </label>
						<div class="col-md-8">
							<input type="hidden"class="form-control form-control-sm" name="id">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-dark"
								data-bs-dismiss="modal">No</button>
							<button type="submit" class="btn btn-primary">Yes</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#example').DataTable();
		});
	</script>
	<script>
		function showModal(assetAssignmentId){			
			document.getElementById("delete-data").id.value=assetAssignmentId;
			$("#deleteAssetAssignment").modal("show");

			}
</script>
	<%@ include file="footer.jsp"%>
</body>
</html>