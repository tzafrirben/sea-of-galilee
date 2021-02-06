# Sea of Galilee

Use [GitHub action](https://github.com/features/actions) to collect water levels measurements for the The Sea of Galilee,
and [Tweet](https://twitter.com/GalileeBot) new measurements.

#### Work flows
1. A scheduled action uses [babashka](https://github.com/babashka/babashka) script to fetch and parse water levels from a remote host. 
If there are new records, they are committed and pushed into the repo under [docs](https://github.com/tzafrirben/sea-of-galilee/blob/master/docs) folder

2. Another scheduled action that post a Tweet if any new measurements were done since last job execution [Send tweet action](https://github.com/marketplace/actions/send-tweet-action) 


#### GitHub Pages
Measurements are also rendered using [Chart.js](https://www.chartjs.org/) in [this](https://tzafrirben.github.io/sea-of-galilee) GitHub page
