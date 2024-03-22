import java.util.*;
import java.util.stream.*;

class Solution {
    private static final class Ticket {
        int step;
        String[] ticket;
        List<Integer> idxList;
        
        private Ticket(int step, String[] ticket, List<Integer> idxList) {
            this.step = step;
            this.ticket = ticket;
            this.idxList = idxList;
        }
    }
    
    public String[] solution(String[][] tickets) {
        List<List<Integer>> possible = new ArrayList<>();
        
        Queue<Ticket> queue = new LinkedList<>();
        queue.offer(new Ticket(0, new String[]{"", "ICN"}, new ArrayList<>()));
        
        while (!queue.isEmpty()) {
            Ticket ticket = queue.poll();
            
            if (ticket.step == tickets.length) {
                possible.add(ticket.idxList);
            }
            
            for (int i = 0; i < tickets.length; i++) {
                if (!available(ticket.ticket, tickets[i])) {
                    continue;
                }
                
                if (ticket.idxList.contains(i)) {
                    continue;
                }
                
                List<Integer> newIdxList = new ArrayList<>(ticket.idxList);
                newIdxList.add(i);
                queue.offer(new Ticket(ticket.step + 1, tickets[i], newIdxList));
            }
        }
        
        List<List<String>> routes = getRoutes(possible, tickets);
        
        return getRoute(routes);
    }
    
    private boolean available(String[] oriTicket, String[] compTicket) {
        return oriTicket[1].equals(compTicket[0]);
    }
    
    private List<List<String>> getRoutes(List<List<Integer>> possible, String[][] tickets) {
        List<List<String>> routes = new ArrayList<>();
        
        for (int i = 0; i < possible.size(); i++) {
            List<Integer> idxes = possible.get(i);
            List<String> route = new ArrayList<>();
            
            for (int j = 0; j < idxes.size(); j++) {
                route.add(tickets[idxes.get(j)][0]);
            }
            route.add(tickets[idxes.get(idxes.size() - 1)][1]);
            
            routes.add(route);
        }
        
        return routes;
    }
    
    private String[] getRoute(List<List<String>> routes) {
        if (routes.size() == 1) {
            return routes.get(0).toArray(String[]::new);
        }
        
        String comp = routes.get(0)
            .stream()
            .collect(Collectors.joining(""));
        int idx = 0;
        
        for (int i = 1; i < routes.size(); i++) {
            String route = routes.get(i)
                .stream()
                .collect(Collectors.joining(""));
            
            if (comp.compareTo(route) > 0) {
                comp = route;
                idx = i;
            }
        }
        
        return routes.get(idx).toArray(String[]::new);
    }
}