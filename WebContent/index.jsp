<!doctype html>

<html lang="en">

<head>
<script type="text/javascript">
window.history.forward();
function noBack() { window.history.forward(); }
var CONTEXT_PATH = '<%=request.getContextPath()%>/';
</script>

<meta charset="utf-8">


<!-- <meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1"> -->

<!--
<meta name="description" content="AXA - Responsive HTML5 Template">
<meta name="author" content="iThemesLab">
 -->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/angular.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/angular-route.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/angular-ui-router.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/bootstrap.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/ngStorage.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/angular-local-storage.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/app.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/grid/ui-grid.min.js"></script>
		<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/angularjs/main/jquery.stickyfooter.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/agent/css/font-awesome.min.css">
 <link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/js/angularjs/main/grid/ui-grid.	min.css">
<!-- <link rel="stylesheet" type="text/css" href="http://ui-grid.info/release/ui-grid-unstable.css"> -->

<!--[if IE 8]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<!--[if lt IE 9]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<script type="text/javascript"
	src="<%=request.getContextPath()%>/alert/dist/sweetalert.min.js"></script>
	 <script type="text/javascript"
	src="<%=request.getContextPath()%>/alert/dist/sweetalert-dev.js"></script>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/alert/dist/sweetalert.css">
        
        <style type="text/css">
#wrap {
	min-height: 60%;
	height: 70%;
	margin: 3 auto -40px;
}

.sampleGrid {
	width: 1030px;
	height: 200px;
}
</style>
</head>
<body>

    
    
        
        <div id="wrap" ng-app="myApp2" ng-controller="GridController"ng-init="gridload()">


		<form >
	<div class="container">
		<div class="form-group" style="margin-right: 50px;">
			<div class="col-md-4">Student Name</div>
			<div class="col-md-8">
			
				<input type="text" ng-model="stud.name"
					class="form-control" ng-blur="fntest()"/>
			</div>
		</div>
		<br>
		<div class="form-group" style="margin-right: 50px;">
			<div class="col-md-4">Course</div>
			<div class="col-md-8">
				<input type="text" ng-model="stud.course"
					class="form-control" autocomplete="off"/>
			</div>
		</div>
		<div class="form-group" style="margin-right: 50px;">
			<div class="col-md-4">Address</div>
			<div class="col-md-8">
			
				<input type="text" ng-model="stud.address"
					class="form-control" ng-blur="fntest()"  
					/>
			</div>
		</div>
		<div class="form-group" style="margin-right: 50px;">
			<div class="col-md-4">Cutoff</div>
			<div class="col-md-8">
				<input type="text" ng-model="stud.cutoff"
					class="form-control" autocomplete="off"/>
			</div>
		</div>
	</div>
</form>
		
		<br>
		<div>
		<span class="input-group-addon">
				<button type="submit" style="width: 60px" ng-click="save()">
				Save <span class="glyphicon glyphicon-search"></span>
				</button>
			</span>
			
			<span class="input-group-addon">
				<button type="submit" style="width: 60px" ng-click="deleteDetails()">
				Delete  <span class="glyphicon glyphicon-search"></span>
				</button>
			</span>
			<span class="input-group-addon">
				<button type="submit" style="width: 60px" ng-click="select()">
				Select <span class="glyphicon glyphicon-search"></span>
				</button>
			</span>
			<span class="input-group-addon">
				<button type="submit" style="width: 60px" ng-click="updateDetails()">
				Update  <span class="glyphicon glyphicon-search"></span>
				</button>
			</span>
			<span class="input-group-addon">
				<button type="submit" style="width: 60px" ng-click="next()">
				Next <span class="glyphicon glyphicon-search"></span>
				</button>
			</span>
		</div>
		<br>
		<div id="content">
			<div id="sampleGrid" ui-grid="sampleGrid" ui-grid-selection
				class="gridStyle" ui-grid-resize-columns></div>
		</div>
		<!-- <p>Total in dollar: <span ng-bind="stud.name"></span></p>
		 -->
		
		
	</div>
	

</body>
</html>
