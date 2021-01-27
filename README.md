# sea-of-galilee

Use [GitHub action](https://github.com/features/actions) to collect and store water levels history for the The Sea of Galilee.

### Work flow
A scheduled action uses [babashka](https://github.com/babashka/babashka) script to fetch and parse water levels from a remote host. 
If there are new records, they are committed and pushed into the repo under [docs] folder (https://github.com/tzafrirben/sea-of-galilee/blob/master/docs)
