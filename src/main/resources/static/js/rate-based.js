$(function() {
	
$('#create-rate-baseds-form').submit(function (e) {
	e.preventDefault();
	
	let ratebased = {
		rate: $('#rate-rate-based').val(),
		client: { 
			id: $('#rate-based-client').val() 
		},
		quantity: $('#rate-based-quantity').val(),
		description: $('#rate-based-description').val()
	};

	let headers = {
		'X-CSRF-TOKEN': $('#rate-based-csrf').val()
	};
	let settings = {
			url: '/api/billing-records/rate-baseds',
			headers: headers,
			data: JSON.stringify(ratebased),
			contentType: 'application/json'
	};
	$.post(settings)
	.done(function (data) {
		$('#fee-table')
			.append(`
		      <tr>
		        <td>${ data.createdBy.username }</td>
		        <td>${ data.description }</td>
		        <td>${ data.client.name }</td>
		        <td>${ data.amount || '' }</td>
		        <td>${ data.rate || '' }</td>
		        <td>${ data.quantity || '' }</td>
		        <td>${ data.total }</td>
		      </tr>
			`);
		$('#rate-rate-based').val('');
		$('#rate-based-client').val('');
		$('#rate-based-quantity').val('');
		$('#rate-based-description').val('');
	});
});	

});
