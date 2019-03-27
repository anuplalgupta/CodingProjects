//public int minTravelDist(int[] hazzard, int ringSize){
//
//    Collection.sort(hazzard);
//    
//    int lastClosestHazard = min(hazard[0], ringSize - hazard[hazard.length()]);
//    Set<Integer> hazardServiced = new HashSet<Integer>();
//    
//    int distanceTraveled = lastClosestHazard;
//    
//    while(hazardServiced.size()< hazzard.length()){
//    
//    
//        int nextClosestHazard = findNextClosesHazzard(lastClosestHazard, hazzardServed, hazzard, ringSize);
//        
//        if(nextClosestHazzard == -1){
//            return distanceTraveled;
//         }
//         
//        distanceTraveled += differnce(lastClosestHazard,nextClosestHazard);
//        
//        lastCloasesHazard = nextClosestHazzard;
//        hazardServiced.add(lastClosestHazzard);
//    }
//
//    return distanceTraveled;
//
//}
//
//
//public int findNextClosestHazzard(int lastClosestHazzard, Set<Integer>hazzardServced, int[] hazzard, int ringSize){
//   int nextHazzard = -1;
//   
//   if(hazzardServced.contains(hazzard[lastClosestHazzard+1]){
//       return findUnservedFromThebottom(hazzard);
//   }
//    
//   if(difference(hazzard[lastClosestHazzard+1] - hazzard[lastClosestHazzard]) > difference(hazzard[lastClosestHazzard] -(ringSize - hazzard[hazzard.length()-1]){
//        nextHazzard = ringSize - hazzard[hazzard.lenght-1];
//    }
//    return nextHazzard;
//}
//
//public int difference(int a, int b, int ringSize){
//
//    return min( abs(b-a), abs(b-(ringSize -a)));
//}
//
//
//public int findUnservedFromTheBottom(int[] hazzard){
//    for(int i = hazzard.lenght()-1;i>=0;i--){
//        if(hazzardServced.contains(i)){
//            continue;
//        }else{
//        return i;
//       }
//     return -1;       
//}            
//    
//
//package practice;
//
//public class Maintenance {
//
//}
