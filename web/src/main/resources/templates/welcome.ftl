<!DOCTYPE html>
<html>
<head>
	<title>Hello World </title>
	<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
  	<h1>Person's List </h1>
		<button data-bind="click: addPerson" class="btn btn-primary" data-toggle="modal" data-target="#myModal">+</button>
		<br></br>
		<table class="table">
		    <thead><tr>
		        <th>Name</th><th>Surname</th><th>identity</th><th></th>
		    </tr></thead>
		    <tbody data-bind="foreach: people">
		      <tr>
		        <td data-bind="text: name" ></td>
		        <td data-bind="text: surname"></td>
		        <td data-bind="text: identity"></td>
		        <td>
		        	<button data-bind="click: $root.editPerson" 
		        		class="btn btn-outline-danger"
		        		data-toggle="modal"
		        		data-target="#myModal">
									<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>		        			
		        		</button>
		        	<button data-bind="click: $root.removePerson" 
	        			class="btn btn-danger">
									<span class="glyphicon glyphicon-minus" aria-hidden="true"></span>		        			
		        	</button>
		        </td>
		    </tr> 
		    </tbody>

		</table>
	</div>
	
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Add a Person </h4>
      </div>
      <div class="modal-body">
				<div class="panel-body">
		     	<form >
					  <div class="form-group">
					    <label>Name</label>
					    <input type="text" class="form-control" data-bind="value: person().name" >
					  </div>
					  <div class="form-group">
					    <label>Surname</label>
					    <input type="text" class="form-control" data-bind="value: person().surname" >
					  </div>
					  <div class="form-group">
					    <label>Identity</label>
					    <input type="text" class="form-control" data-bind="value: person().identity" >
					  </div>
	      	</form>
				</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" data-bind="click: savePerson" >Save</button>
      </div>
    </div>
  </div>
</div>
  <script type="text/javascript" src="assets/js/jquery-3.2.1.min.js"></script>
  <script type="text/javascript" src="assets/js/knockout-3.4.2.js"></script>
  <script type="text/javascript" src="assets/js/tether.min.js"></script>
  <script type="text/javascript" src="assets/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="index.js"></script>
</body>
</html>