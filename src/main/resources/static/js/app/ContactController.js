'use strict';

angular.module('crudApp').controller('ContactController',
    ['ContactService', '$scope',  function( ContactService, $scope) {

        var self = this;
        self.contact = {};
        self.contacts=[];

        self.submit = submit;
        self.getAllContacts = getAllContacts;
        self.createContact = createContact;
        self.updateContact = updateContact;
        self.removeContact = removeContact;
        self.editContact = editContact;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;
		self.emailPattern = "^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$";

        function submit() {
            console.log('Submitting');
            if (self.contact.id === undefined || self.contact.id === null) {
                console.log('Saving New Contact', self.contct);
                createContact(self.contact);
            } else {
                updateContact(self.contact, self.contact.id);
                console.log('Contact updated with id ', self.contact.id);
            }
        }

        function createContact(contact) {
            console.log('About to create contact');
            ContactService.createContact(contact)
                .then(
                    function (response) {
                        console.log('Contact created successfully');
                        self.successMessage = 'Contact created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.contact={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating Contact');
                        self.errorMessage = 'Error while creating Contact: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateContact(contact, id){
            console.log('About to update contact');
            ContactService.updateContact(contact, id)
                .then(
                    function (response){
                        console.log('Contact updated successfully');
                        self.successMessage='Contact updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating Contact');
                        self.errorMessage='Error while updating Contact '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeContact(id){
            console.log('About to remove Contact with id '+id);
            ContactService.removeContact(id)
                .then(
                    function(){
                        console.log('Contact '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing contact '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllContacts(){
            return ContactService.getAllContacts();
        }

        function editContact(id) {
            self.successMessage='';
            self.errorMessage='';
            ContactService.getContact(id).then(
                function (contact) {
                    self.contact = contact;
                },
                function (errResponse) {
                    console.error('Error while removing contact ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.contact={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }
]);