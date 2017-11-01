var gridmodule = angular.module('myApp2', ['ui.grid','ui.grid.resizeColumns','ui.grid.selection']);
/*'ui.grid.pagination','ui.grid.selection'*/

	
gridmodule.controller('GridController', function($rootScope,$scope, $http,$timeout,$q) {

	 $scope.sampleGrid={
			    data:'empdetail',
			//	enableHiding: false,
				enableSorting: true,
			    enableFiltering: false,
			    showFooter: true,
			    enableColumnResize: true,
				columnDefs: [{field:'name', displayName: 'StudentName',width:250,enableSorting: true,enableHiding: false },
				             {field:'course', displayName:'Course',width:250,enableSorting: true,enableHiding: false},
				             {field:'address', displayName:'Address',width:250,enableSorting: true,enableHiding: false},
				             {field:'cutoff', displayName:'Cutoff',width:250,enableSorting: true,enableHiding: false}
				          
				             ]
	    };
	 $scope.sampleGrid.onRegisterApi = function(gridApi){
		   $scope.gridApi = gridApi;
		   
		   gridApi.selection.on.rowSelectionChanged($scope, function(row){ 
		    $scope.countRows = $scope.gridApi.selection.getSelectedRows();
//		    alert(JSON.stringify($scope.countRows));
		    console.log('It is a single selection.! '+JSON.stringify($scope.countRows));
		    });
		   
		   gridApi.selection.on.rowSelectionChangedBatch($scope,function(row){
	    	$scope.countRows = $scope.gridApi.selection.getSelectedRows();
	    	console.log('You are selected the whole rows '+JSON.stringify($scope.countRows));
		   });
		};
		 
		$scope.save = function() {
			var det = $scope.stud;
			 $http.post(CONTEXT_PATH+"save.do",det).then(function(response) {
					$scope.detail = response.data;
					alert("Added successfully");
					$scope.gridload();	
					});
			
			};
		 $scope.gridload = function() {
			 $http.post(CONTEXT_PATH+"retrive.do").then(function(response) {
					$scope.empdetail = response.data;
				 
						
					});
			
			};
			
			
			$scope.select = function() {
//				

				$http.post(CONTEXT_PATH+"update.do",$scope.countRows).then(
					function(response) {
						/*$scope.empdetail = response.data;*/

						alert("update js");
						alert(response);
						/*alert(response.size());*/
						$scope.stud = response.data;
						
						
					});
			};
			
			$scope.next = function() {
				$http.get(CONTEXT_PATH+"nextpage.do").then(
					function(response) {
						alert("update js");
						$scope.det = response.data;
					});
			};
			
			$scope.deleteDetails = function() {
//				

				$http.post(CONTEXT_PATH+"deletelist.do",$scope.countRows).then(
					function(response) {
						$scope.empdetail = response.data;
						
					});
			};
			$scope.updateDetails = function() {
//				
				var det = $scope.stud;
				alert("update");
				 $http.post(CONTEXT_PATH+"details.do",det).then(function(response) {
						$scope.detail = response.data;
						alert("Updated successfully");
						$scope.gridload();	
						});
				
			};
	});