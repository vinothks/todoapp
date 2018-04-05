var todoApp = angular.module('todoApp', []);
todoApp.controller('todoCtrl', function($scope,$http) {
    $scope.name = "Vinoth";
    
    $scope.getTodoList = function(){
    	$http({
    		method : 'GET',
    		url : 'todo/gettodolist'
    	}).then(function(response){
    		$scope.todoList = response.data.customData;
    		$scope.todo = {todoDesc:null,todoCompleted:false};
    	   },function(error){
    		   alert("error");
    	   });
    }
    
    $scope.addTodo = function(){
    	$http({
    		method : 'POST',
    		url : 'todo/addtodo/',
    		data : $scope.todo,
    		headers: {
                'Content-Type': 'application/json'
            }
    	}).then(function(response){
    		$scope.getTodoList();
    	   },function(error){
    		   alert("error");
    	   });
    }
    
    $scope.updateTodo = function(todo){
    	$http({
    		method : 'POST',
    		url : 'todo/updatetodo/',
    		data : todo,
    		headers: {
                'Content-Type': 'application/json'
            }
    	}).then(function(response){
    		$scope.getTodoList();
    	   },function(error){
    		   alert("error");
    	   });
    }
    
    $scope.deleteTodo = function(todoId){
    	$http({
    		method : 'DELETE',
    		url : 'todo/deletetodo/',
    		data : todoId,
    		headers: {
                'Content-Type': 'application/json'
            }
    	}).then(function(response){
    		$scope.getTodoList();
    	   },function(error){
    		   alert("error");
    	   });
    }
    
});