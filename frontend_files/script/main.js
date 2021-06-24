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