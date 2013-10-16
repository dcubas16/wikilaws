<%@	taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="row" id="upper-navbar">
	<div class="col-md-1"></div>
	<div class="col-md-6 search-bar-separator">
		<div class="page-content">
			<div class="input-group">
				<input type="text" class="form-control input-group-small"
					placeholder="Buscar..." data-bind="value: viewModelUpperNavBar.searchInput"> <span class="input-group-btn">
					<button class="btn btn-primary btn-md" type="button"
						data-bind="click: searchButtonClick">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>
			</div>
		</div>
	</div>
	<div class="col-md-5" align="right">
	</div>
</div>
<script
	src="../wikilaws/resources/javascript/wikilaws/upper-nav-bar.js"
	type="text/javascript"></script>	