$("#datepicker").datepicker();

function showMatch(id) {
	$("#lolkin").val(id);
	create_Ajax(id);
}

function create_Ajax(id) {

	$("#divdate").show();

	var search = {}
	search["selectedId"] = id;

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/api/getMatches",
		data : JSON.stringify(search), // send our string
		dataType : 'json',
		cache : false,
		timeout : 0,

		success : function(data) {

			// define global array with data from ajax response
			globalMatches = data.matches;

			var response = matchesToHtml(data.matches); // createRadioButtonResponseForMatches(data);

			$('#feedback_for_Matches').html(response);

			console.log("SUCCESS : ", data);
		},
		error : function(e) {

			var json = "<h4>Ajax Response Error</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedback_for_Matches').html(json);

			console.log("ERROR : ", e);
		}

	});

}

function matchesToHtml(matches) {

	var html = " ";

	for (let i = 0; i < matches.length; i++) {

		html += "<br><br>";
	
		html += '</div>';

		html += "<h3>"
				+ matches[i].matchName
				+ "</h3>"
				+ ' <button type="submit"><a  style="color:black"href="api/showMatchInfo?id='
				+ matches[i].id + '">show match info</a></button>' + "<br>";

		html += "<br>Match for " + matches[i].skillLevel;
		html += "<br>entryFee is:" + matches[i].entryFee;
		html += "<br>capacity is:" + matches[i].capacity + "<br><br>";
	}

	html += '<h4> There is no an appropriate match for You? You can create your own. </h4>';
	html += '<button style="margin-right: 10px" type="button" class="btn btn-success" ><a href="/NewMatch" style="color:white">Create new match</a></button> ';

	return html;
}

function SortByDate() {

	var date = String($("#datepicker").val());

	var ResultArray = [];

	for (let i = 0; i < globalMatches.length; i++) {

		let matchDate = globalMatches[i].date.replace(/-/g, "/");

		if (new Date(matchDate).getTime() == new Date(date).getTime())
			ResultArray.push(globalMatches[i]);
	}

	$('#feedback_for_Matches').html(matchesToHtml(ResultArray));
}
