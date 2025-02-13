using backed_.NET.Models;
using backed_.NET.Services;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using backed_.NET.DTO;

namespace backed_.NET.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly IUserService _userService;

        public UserController(IUserService userservice)
        {
            _userService = userservice;
        }

        [HttpPost("signup")]
        public async Task<ActionResult<User>> registerCompany([FromBody] User user)
        {
            var createdUser = await _userService.addUser(user);
            if (createdUser == null)
            {
                return BadRequest("UserName Already Exists");
            }

            return CreatedAtAction(nameof(registerCompany), createdUser);

        }



        [HttpPost("login")]
        public async Task<ActionResult<User>> login([FromBody] UserDto userdto)
        {
            var existingUser = await _userService.validateUser(userdto.Username, userdto.Password);
            if (existingUser == null)
            {
                return Unauthorized("Invalid UserName and Password");
            }

            return Ok(existingUser);
        }

        [HttpGet("{username}")]
        public async Task<ActionResult<User>> GetUser(string username)
        {
            var user = await _userService.getUserByUsername(username);
            if (user == null)
            {
                return NotFound();
            }

            return Ok(user);
        }




    }
}
