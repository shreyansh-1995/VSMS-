import axios from 'axios'

const URL = 'http://localhost:8080/service'

class ServiceAdvFunctions {
  addNewJobCard(jobCard) {
    return axios.post(URL + '/add',jobCard)
  }

  getAllMechanics() {
    return axios.get(URL + '/fetchmechanic')
  }

  getAllRecentJobCards() {
    return axios.get(URL + '/fetchrecentjobs')
  }

  getAllJobCardsCount() {
    return axios.get(URL + '/counttotaljobs')
  }
  

}
export default new ServiceAdvFunctions()
