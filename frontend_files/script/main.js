	var myArray = []

	buildTable(myArray)
	
	$.ajax({
		method:'GET',
		url:'http://localhost:8989/card/all',
		success:function(response){
			myArray = response.data
			buildTable(myArray)
			console.log(myArray)
		}
	})



	function buildTable(data){
		var table = document.getElementById('myTable')

		for (var i = 0; i < data.length; i++){
			var row = `<tr>
							<td>${data[i].set}</td>
							<td>${data[i].german}</td>
							<td>${data[i].english}</td>
							<td>${data[i].turkish}</td>
							<td>${data[i].spanish}</td>
					  </tr>`
			table.innerHTML += row


		}
	}
	
function addCard(){
    var card = {
		name: $('#name').val(),
		german: $('german').val(),
		english: $('english').val(),
		turkish: $('turkish').val(),
		spanish: $('spanish').val(),
	};
	$.ajax({
		url: 'http://localhost:8989/card/add',
		type: 'POST',
		data: JSON.springify(card),
		success: function(data){
			alert('Card added successfully')
		},
		error: function(){
			alert('Card was not added');
		}
	});
}

