$(function() {
	
$('#create-billing-records-form').submit(function (e) {
	e.preventDefault();
	
	let fee = {
		amount: $('#flat-fee-amount').val(),
		client: { id: $('#flat-fee-client').val() },
		description: $('#flat-fee-description').val()
	};

	let headers = {
		'X-CSRF-TOKEN': $('#flat-fees-csrf').val()
	};
	let settings = {
			url: '/api/billing-records/flat-fees',
			headers: headers,
			data: JSON.stringify(fee),
			contentType: 'application/json'
	};
	$.post(settings)
	.done(function (data) {
		$('#fee-table')
			.append(`
		      <tr>
		        <td></td>
		        <td>${ data.description }</td>
		        <td>${ data.client.name }</td>
		        <td>${ data.amount || '' }</td>
		        <td>${ data.rate || '' }</td>
		        <td>${ data.quantity || '' }</td>
		        <td>${ data.total }</td>
		       </tr>
			`);
		$('#billing-records-amount').val('');
	});
});	

});

