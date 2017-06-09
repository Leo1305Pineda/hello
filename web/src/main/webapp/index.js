// Class to represent a row in the seat reservations grid
function Person(person) {
  var self = this;
  self.id = person.id;
  self.name = ko.observable(person.name);
  self.surname = ko.observable(person.surname);
  self.identity = ko.observable(person.identity);
}

// Overall viewmodel for this screen, along with initial state
function ReservationsViewModel() {
  var self = this;
  // Non-editable catalog data - would come from the server
  self.people = ko.observableArray([]);
  self.person = ko.observable(new Person({ 
        id: null,
        name: "",
        surname: "",
        identity: ""}
      ));

  self.addPerson = function() {
     self.person(new Person({ 
        id: null,
        name: "",
        surname: "",
        identity: ""}
      ));
  }
  self.savePerson = function () {
    data = {
      name: self.person().name(),
      surname: self.person().surname(),
      identity: self.person().identity()
    };

    let url = "http://localhost:8080/people/";
    let type = "POST";
    if(self.person().id != null){
      url = "http://localhost:8080/people/" +self.person().id
      type = "PUT";
    }
    $.ajax({
      type: type,
      url: url,
      data: JSON.stringify(data),
      success: function(val){
        self.loadPersons();
      },
      contentType: "application/json",
      dataType: "json"
    });
    $("#myModal").modal('hide');
  }

  self.editPerson = function(){
    self.person(new Person(this));
  }

  self.removePerson=function(){
    url = "http://localhost:8080/people/" +this.id
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
  	console.log("Loading person :-D ");
 	 	$.get("http://localhost:8080/people", function(res){
 	 		self.people(res);
    });
  }
	this.loadPersons();
}
ko.applyBindings(new ReservationsViewModel());