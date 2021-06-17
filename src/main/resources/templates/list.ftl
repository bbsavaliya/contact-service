<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Contact </span></div>
		<div class="panel-body">
	        <div class="formcontainer">
	            <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
	            <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
	            <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
	                <input type="hidden" ng-model="ctrl.contact.id" />
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="firstName">FirstName</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.contact.firstName" id="firstName" class="username form-control input-sm" placeholder="Enter your first name." required ng-minlength="3"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="lastname">LastName</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.contact.lastName" id="lastname" class="form-control input-sm" placeholder="Enter your last name." required />
	                        </div>
	                    </div>
	                </div>
	
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="email">Email</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.contact.email" id="email" ng-pattern="ctrl.emailPattern" class="form-control input-sm" placeholder="Enter your email." required />
	                        </div>
	                    </div>
	                </div>
	                
	                <div class="row">
	                    <div class="form-group col-md-12">
	                        <label class="col-md-2 control-lable" for="phone">Phone No</label>
	                        <div class="col-md-7">
	                            <input type="text" ng-model="ctrl.contact.phoneNum" id="phone" class="form-control input-sm" placeholder="Enter your phone number." required ng-pattern="ctrl.onlyIntegers" ng-minlength="10"/>
	                        </div>
	                    </div>
	                </div>

	                <div class="row">
	                    <div class="form-actions floatRight">
	                        <input type="submit"  value="{{!ctrl.contact.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
	                        <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
	                    </div>
	                </div>
	            </form>
    	    </div>
		</div>	
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Contacts </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>ID</th>
		                <th>FIRSTNAME</th>
		                <th>LASTNAME</th>
		                <th>EMAIL</th>
		                <th>PHONE NO</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="c in ctrl.getAllContacts()">
		                <td>{{c.id}}</td>
		                <td>{{c.firstName}}</td>
		                <td>{{c.lastName}}</td>
		                <td>{{c.email}}</td>
		                <td>{{c.phoneNum}}</td>
		                <td><button type="button" ng-click="ctrl.editContact(c.id)" class="btn btn-success custom-width">Edit</button></td>
		                <td><button type="button" ng-click="ctrl.removeContact(c.id)" class="btn btn-danger custom-width">Remove</button></td>
		            </tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>