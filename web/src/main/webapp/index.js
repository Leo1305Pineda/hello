function Person(person) {
  var self = this;   
  self.id = person.id;  
  self.name = ko.observable(person.name);
  self.surname = ko.observable(person.surname);
  self.identity = ko.observable(person.identity);
}

function ReservationsViewModel() {
  var self = this;

  self.people = ko.observableArray([]);
  self.formError = ko.observable(null);
  
  self.person = ko.observable(new Person({ 
     id: null,
     name: "",
     surname: "",
     identity: ""})
  );

  self.addPerson = function() {
     self.person(new Person({ 
        id: null,
        name: "",
        surname: "",
        identity: ""}
      ));
  }
  
  self.savePerson = function () {
    self.formError(null);
    data = {
      name: self.person().name(),
      surname: self.person().surname(),
      identity: self.person().identity()
    };
    let url = "/people/";
    let type = "POST";
    if(self.person().id != null){
      url = "/people/" +self.person().id
      type = "PUT";
    }
    $.ajax({
      type: type,
      url: url,
      data: JSON.stringify(data),
      success: function(val){
        self.loadPersons();
        $("#myModal").modal('hide');
      },
      error:function(error){
    	  if(error.status = 422){
    		 let obj = error.responseJSON;
    		 let msj = "";
    		 if(obj.identity){
    			 msj += " identity: " + obj.identity+" ";
    		 }
    		 if(obj.name){
    			 msj += " name: " + obj.name+" ";
    		 }
    		 if(obj.surname){
    			 msj += " surname: " + obj.surname+" ";
    		 }
    		 self.formError(msj);
    	  }
    	  else{
        	  self.formError("Here, There a error");
    	  }
      },
      contentType: "application/json",
      dataType: "json"
    });
  }

  self.editPerson = function(){
    self.person(new Person(this));
  }

  self.removePerson=function(){
    url = "/people/" +this.id
    type = "DELETE";
    $.ajax({
      type: type,
      url: url,
      success: function(val){
        self.loadPersons();
      },
      contentType: "application/json",
      dataType: "json"
    });
  }

  self.loadPersons = function loadPersons (){
  	console.log("Loading person ");
 	 	$.get("/people", function(res){
 	 		self.people(res);
    });
  }
	this.loadPersons();
}
ko.applyBindings(new ReservationsViewModel());