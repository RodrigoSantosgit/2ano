entity ieee;
use ieee.std_logic_vector.all;
use numeric_std.all;

entity RAM is

	generic( ADDR_BUS_SIZE : positive;
				DATA_BUS_SIZE : positive);
	
	port(	clk : in std_logic;
			addr: in std_logic_vector(ADDR_BUS_SIZE-1 downto 0);
			ce : in std_logic;
			wr : in std_logic;
			rd : in std_logic;
			dio : inout std_logic_vector(DATA_BUS_SIZE-1 downto 0));
			
end RAM;

architecture Behavioral of RAM is

	subtype TData is std_logic_vector(ADDR_BUS_SIZE-1 downto 0);
	type TMemory is array(0 to 64) of TData;
	signal s_mem: TMemory;
	signal s_rdData : std_logic_vector(DATA_BUS_SIZE-1 downto 0);

begin 
	process(clk)
	begin
		if(rising_edge(clk)) then
			if(ce = '1' and wr = '1') then
				s_mem(to_integer(unsigned(addr))) <= dio;
			end if;
		end if;	
		
	end process;
	
	s_rdData <= s_mem(to_integer(unsigned(addr)));
	dio <= s_rdData when ce = '1' and rd = '1' and wr = '0' else (others => 'Z');
	
end Behavioral;