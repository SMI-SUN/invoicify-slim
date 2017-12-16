$(function() {
	
$('#create-companies-form').submit(function (e) {
	e.preventDefault();
	
	let company = {
			name: $('#company-name').val()
	};
	let headers = {
		'X-CSRF-TOKEN': $('#company-csrf').val()
	};
	let settings = {
			url: '/api/admin/companies',
			headers: headers,
			data: JSON.stringify(company),
			contentType: 'application/json'
	};
	$.post(settings)
	.done(function (data) {
		$('#company-list')
			.append(`<li>${data.name}</li>`);
		$('#company-name').val('');
	});
});	

});