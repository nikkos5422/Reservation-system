$(document).ready(function() {

	$("#search-form").submit(function(event) {

		// stop submit the form, we will post it manually.
		event.preventDefault();

		fire_ajax_submit();

	});

});

function testing(selectedCity) {
	fire_ajax_submit(selectedCity);
}

function fire_ajax_submit(selectedCity) {

	var search = {}

	if (selectedCity) {

		search["selectedCity"] = selectedCity;
	} else {

		search["selectedCity"] = $("#selectedCity").val();
		$("#btn-search").prop("disabled", true);
	}

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/getGrounds",
		data : JSON.stringify(search), // send our string
		dataType : 'json',
		cache : false,
		timeout : 0,

		success : function(data) {

			var response = createRadioButtonResponseForGrounds(data);
			$('#feedback_for_Grounds').html(response);

			console.log("SUCCESS : ", data);
			$("#btn-search").prop("disabled", false);

		},
		error : function(e) {

			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedback_for_Grounds').html(json);

			console.log("ERROR : ", e);
			$("#btn-search").prop("disabled", false);

		}
	});
}

function createRadioButtonResponseForGrounds(data) {

	var reztmp = '';
	for (let i = 0; i < data.grounds.length; i++) {

		reztmp += '<div class="col-sm-6"><div class="card" style="width: 15rem; height:18rem;">'
				+ '<img class="card-img-top" src="'
				+ data.grounds[i].image
				+ '" alt="Card image cap"><div class="card-body">';

		reztmp += '<div class="card-title"><div class="row"><div class="col-sm-7"><div class="ground_name">'
				+ data.grounds[i].groundName
				+ '</div></div><div class="col-sm-5" ы>Select:<input type="radio" name="grounds"  value=" '
				+ data.grounds[i].id
				+ ' "  onclick="showMatch('
				+ data.grounds[i].id + ');"' + '\/></div></div></div>';
		reztmp += '<p class="card-text">' + data.grounds[i].address
				+ '<div><b>Covering</b>: ' + data.grounds[i].covering
				+ '</div></p>';
		reztmp += '</div></div></div>'

	}

	// return json;
	return reztmp;
}
